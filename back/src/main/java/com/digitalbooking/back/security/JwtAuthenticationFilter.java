package com.digitalbooking.back.security;

import com.digitalbooking.back.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// This custom filter handles the JWT token verification process for incoming requests.
// It extends OncePerRequestFilter and overrides the doFilterInternal method
// to validate the JWT token and set the Authentication object in the SecurityContextHolder.
// The authentication process is managed in LoginUserPostController and this filter focuses on verifying JWT tokens for incoming requests.
@AllArgsConstructor
@Log4j2
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Checking JWT token in incoming request.");

        String authorizationHeader = request.getHeader("Authorization");

        // If the Authorization header is not null and starts with "Bearer ",
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            log.info("Authorization header found, extracting JWT token.");
            String jwt = authorizationHeader.substring(7);
            Authentication authentication = jwtUtil.validateTokenAndGetAuthentication(jwt);

            if (authentication != null) {
                log.info("JWT token is valid, setting authentication in SecurityContextHolder.");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                log.warn("JWT token is invalid or expired.");
            }
        } else {
                log.info("No Authorization header or it doesn't start with 'Bearer '. Skipping JWT verification.");
        }

        filterChain.doFilter(request, response);
    }
}
