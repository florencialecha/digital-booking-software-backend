package com.digitalbooking.back.config;

import com.digitalbooking.back.management.users.UserService;
import com.digitalbooking.back.security.JwtAuthenticationFilter;
import com.digitalbooking.back.utils.JwtUtil;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.expiration-in-ms}")
    private int jwtExpirationInMs;

    @Autowired
    private UserService userService;

    //MANAGE AUTHORIZATION
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .httpBasic()
                .and()
                .authorizeRequests()

                //PUBLIC RESOURCES

                    //Sign up: new user
                    .requestMatchers(HttpMethod.POST, "sign_up").permitAll()
                    //Sign in: user existing
                    .requestMatchers(HttpMethod.POST, "login").permitAll()

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

                //USER RESOURCES

                    //Call on product details page | Product details component | Get product by id with all data
                    .requestMatchers(HttpMethod.GET,"/product/{id}").hasRole("USER")
                    //Call on product details page | Product details component | Calendar reservations | Get all reservations by product id
                    .requestMatchers(HttpMethod.GET,"/reserve/byProductId/{idProduct}").hasRole("USER")

                    //Call on reserve page | Reserve component | Post new reserve with user info
                    .requestMatchers(HttpMethod.POST, "/reserve").hasRole("USER")

                //HOST RESOURCES

                    //Call on host page | New product component | Post new product
                    //.requestMatchers(HttpMethod.POST, "/product").hasRole("HOST")

                //ADMIN RESOURCES

                    //Call on admin page | New feature component | Post new feature
                    .requestMatchers(HttpMethod.POST, "/feature").hasRole("ADMIN")
                    //Call on admin page | New country component | Post new country with states and cities
                    .requestMatchers(HttpMethod.POST, "/country").hasRole("ADMIN")
                    //Call on admin page | New category component | Post new category
                    .requestMatchers(HttpMethod.POST, "/category").hasRole("ADMIN")

                    //Don't call on any page | Admin component | Get all users
                    .requestMatchers(HttpMethod.GET,"/product").hasRole("ADMIN")

                //ANY OTHER REQUEST

                .anyRequest().permitAll()
//                .and()
//                .build();

                //desabilitar csrf para poder hacer peticiones desde postman
                .and().csrf().disable().build();
    }


    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtUtil());
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(userService, secretKey, jwtExpirationInMs);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
        return auth.build();
    }

    //MANAGE PASSWORD
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}
