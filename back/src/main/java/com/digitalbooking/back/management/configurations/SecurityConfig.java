package com.digitalbooking.back.management.configurations;

import com.digitalbooking.back.management.users.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CreateUserService createUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .antMatchers("/user/**").permitAll() // Permitir acceso sin autenticación a la ruta /user/**
                .anyRequest().authenticated() // Requerir autenticación para todas las demás rutas
                .and().csrf().disable() // Deshabilitar la protección CSRF
                .formLogin().disable() // Deshabilitar el login por formulario
                .httpBasic().and() // Habilitar la autenticación básica de HTTP
                .userDetailsService(createUserService)
                .passwordEncoder(passwordEncoder)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
