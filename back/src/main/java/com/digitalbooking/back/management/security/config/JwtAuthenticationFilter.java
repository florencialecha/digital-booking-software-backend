package com.digitalbooking.back.management.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//Hay que decirle a Spring que esto va a manejar las peticiones
@Component
@RequiredArgsConstructor
@Log4j2
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    //Permite interceptar todas las peticiones que llegan al sistema
    @Override
    protected void doFilterInternal(
            //Estos 3 parámetros no deberían ser nulos
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain // Contiene los demás filtros que le queremos hacer
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");  //Extrae el encabezado de la petición
        final String jwt;  // Es el token que se va a recibir en el encabezado
        final String username;  // Es el nombre de usuario que se va a recibir en el encabezado
        //Si el encabezado no es nulo y empieza con Bearer
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
          filterChain.doFilter(request, response);
          return;
        }
        jwt = authHeader.substring(7); //Extrae el token
        username = jwtService.extractUsername(jwt); // extrat the username from JWT token;
        //Si el nombre de usuario no es nulo y usuario no está autenticado
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (jwtService.isTokenValid(jwt, userDetails)) {
                //Si el token es válido, se crea un objeto de autenticación
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
            filterChain.doFilter(request, response);
        }
    }
}
