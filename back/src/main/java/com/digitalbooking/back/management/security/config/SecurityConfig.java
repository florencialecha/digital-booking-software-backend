package com.digitalbooking.back.management.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
                .authorizeHttpRequests()

                //PUBLIC RESOURCES

                    //Swagger documentation
                    .requestMatchers("swagger-ui.html").permitAll()
                    //Sign up: new user and Login: existing user
                    .requestMatchers("/auth/**").permitAll()
                    //Call on home page | Searcher component | List all cities with countries
                    .requestMatchers(HttpMethod.GET,"/product/byCityAndDates/{cityName}/{checkIn}/{checkOut}").permitAll()
                    //Call on home page | Searcher component | List all cities with countries
                    .requestMatchers(HttpMethod.GET, "/country").permitAll()
                    //Call on home page | Searcher component | List all cities with countries
                    .requestMatchers(HttpMethod.GET,"/product/byCity/{cityName}").permitAll()
                    //Call on home page | Carrousel component | Get all categories of products
                    .requestMatchers(HttpMethod.GET,"/category").permitAll()
                    //Call on home page | Suggested products component | Get 8 products random
                    .requestMatchers(HttpMethod.GET,"/product/random").permitAll()
                    //Call on home page | Suggested products component | Select all products by category id
                    .requestMatchers(HttpMethod.GET,"/product/byCategory/{categoryId}").permitAll()
                    //Call on product details page | Product details component | Get product by id with all data
                    .requestMatchers(HttpMethod.GET,"/product/{id}").permitAll()

                //REQUIRED AUTHENTICATED RESOURCES

                    //Call on product details page | Product details component | Calendar reservations | Get all reservations by product id
                    .requestMatchers(HttpMethod.GET,"/reserve/byProductId/{idProduct}").authenticated()
                    //Call on user details page | My reserves | Get all reservations by user id
                    .requestMatchers(HttpMethod.GET,"/reserve/byUserId/{idUser}").authenticated()
                    //Call on reserve page | Reserve component | Post new reserve with user info
                    .requestMatchers(HttpMethod.POST, "/reserve").authenticated()

                //HOST RESOURCES

                    //Call on host page | New product component | Post new product
                    .requestMatchers(HttpMethod.POST, "/product").hasAuthority("HOST")

                //ADMIN RESOURCES

                    //Don't call on any page | Admin component | Get all users
                    .requestMatchers(HttpMethod.GET, "/product").hasAuthority("ADMIN")
                    //Call on host page | Update product component | Update product
                    .requestMatchers(HttpMethod.PUT, "/product").hasAuthority("ADMIN")
                    //Call on host page | Category component | Crate new category
                    .requestMatchers(HttpMethod.POST, "/category").hasAuthority("ADMIN")
                    //Call on host page | Category component | Delete category
                    .requestMatchers(HttpMethod.DELETE, "/category/{id}").hasAuthority("ADMIN")
                    //Call on host page | Category component | Find category by id
                    .requestMatchers(HttpMethod.GET, "/category/{id}").hasAuthority("ADMIN")
                    //Call on host page | Category component | Update category
                    .requestMatchers(HttpMethod.PUT, "/category").hasAuthority("ADMIN")
                    //Call on host page | Create feature component | Create feature
                    .requestMatchers(HttpMethod.POST, "/feature").hasAuthority("ADMIN")
                    //Call on host page | Create country component | Create country with states and cities
                    .requestMatchers(HttpMethod.POST, "/country").hasAuthority("ADMIN")

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
