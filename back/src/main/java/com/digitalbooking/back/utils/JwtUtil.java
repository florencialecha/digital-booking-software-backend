package com.digitalbooking.back.utils;

import com.digitalbooking.back.management.authority.Authority;
import com.digitalbooking.back.management.users.UserService;
import com.digitalbooking.back.security.CustomAuthentication;
import com.digitalbooking.back.security.SecurityAuthority;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Log4j2
@AllArgsConstructor
public class JwtUtil {
    @Autowired
    private UserService userService;
    private final String secretKey;
    private final int jwtExpirationInMs;

    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Date getExpirationDateFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        Date expirationDate = getExpirationDateFromToken(token);

        return username.equals(userDetails.getUsername()) && !isTokenExpired(expirationDate);
    }

    private boolean isTokenExpired(Date expirationDate) {
        return expirationDate.before(new Date());
    }

    public Authentication validateTokenAndGetAuthentication(String token) {
        try {
            String username = getUsernameFromToken(token);

            if (username != null) {
                log.info("Validating JWT token for user: {}", username);
                UserDetails userDetails = userService.loadUserByUsername(username);

                if (validateToken(token, userDetails)) {
                    log.info("JWT token is valid for user: {}", username);
                    Collection<SecurityAuthority> authorities = userDetails.getAuthorities().stream()
                            .map(authority -> new SecurityAuthority((Authority) authority))
                            .collect(Collectors.toList());
                    return new CustomAuthentication(userDetails, authorities);
                }
            }
        } catch (Exception e) {
            log.warn("Failed to validate JWT token: {}", e.getMessage());
        }

        return null;
    }

}
