package com.digitalbooking.back.config;

import com.digitalbooking.back.management.users.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //Recursos disponibles y quienes deben tener acceso a ellos
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic()
                .and()
                .authorizeRequests()

                //RECURSOS PÚBLICOS

                //POST /user - Todos
                .requestMatchers(HttpMethod.POST, "/signup").permitAll()
                //GET /product/random - Todos
                .requestMatchers(HttpMethod.GET,"/product/random").permitAll()
                //GET /country - Todos
                .requestMatchers(HttpMethod.GET, "/country").permitAll()
                //GET /category - Todos
                .requestMatchers(HttpMethod.GET,"/category").permitAll()
                //GET /product/byCity/{cityName} - Todos
                .requestMatchers(HttpMethod.GET,"/product/byCity/{cityName}").permitAll()
                //GET /product/byCategory/{categoryId} - Todos
                .requestMatchers(HttpMethod.GET,"/product/byCategory/{categoryId}").permitAll()
                //GET /product/byCityAndDates/{cityName}/{checkIn}/{checkOut} - Todos
                .requestMatchers(HttpMethod.GET,"/product/byCityAndDates/{cityName}/{checkIn}/{checkOut}").permitAll()

                //RECURSOS PARA USUARIOS

                //GET /product/{id} - User autenticado
                .requestMatchers(HttpMethod.GET,"/product/{id}").hasRole("USER")
                //GET /reserve/byProductId/{idProduct} - User autenticado
                .requestMatchers(HttpMethod.GET,"/reserve/byProductId/{idProduct}").hasRole("USER")
                //POST /reserve - User autenticado
                .requestMatchers(HttpMethod.POST, "/reserve").hasRole("USER")

                //RECURSOS PARA HOSTS

                //POST /product - Host autenticado
                //.requestMatchers(HttpMethod.POST, "/product").hasRole("HOST")

                // RECURSOS PARA ADMINISTRADORES

                //GET /product - Admin autenticado
                .requestMatchers(HttpMethod.GET,"/product").hasRole("ADMIN")
                //POST /feature - Admin autenticado
                .requestMatchers(HttpMethod.POST, "/feature").hasRole("ADMIN")
                //POST /country - Admin autenticado
                .requestMatchers(HttpMethod.POST, "/country").hasRole("ADMIN")
                //POST /category - Admin autenticado
                .requestMatchers(HttpMethod.POST, "/category").hasRole("ADMIN")


                // CUALQUIER OTRA SOLICITUD NO ESPECIFICADA

                .anyRequest().permitAll()
//                .and()
//                .build();

                //desabilitar csrf para poder hacer peticiones desde postman
                .and().csrf().disable().build();
    }

    //Se encarga de manejar las contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
