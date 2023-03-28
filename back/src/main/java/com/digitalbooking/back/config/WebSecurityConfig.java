package com.digitalbooking.back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        var user = User.withUsername("user")
//                .password("password")
//                .roles("read")
//                .build();
//
//        //DEV: Devuelve una de las implementaciones de UserDetailsService
//        return new InMemoryUserDetailsManager(user);
//    }

    //DEV: Lo otro que necesita saber Spring Security es quién maneja las contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        //No apto para producción
        return NoOpPasswordEncoder.getInstance();
    }
}
