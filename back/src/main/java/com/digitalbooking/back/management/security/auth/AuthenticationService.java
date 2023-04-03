package com.digitalbooking.back.management.security.auth;

import com.digitalbooking.back.management.security.config.JwtService;
import com.digitalbooking.back.management.security.users.Role;
import com.digitalbooking.back.management.security.users.User;
import com.digitalbooking.back.management.security.users.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        log.info("Executing AuthenticationService.register()");

        // Verifica si el nombre de usuario ya existe
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            log.error("Username already exists");
            throw new IllegalArgumentException("Username already exists");
        }

        //todo: esto se podría hacer con el ModelMapper?
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        log.info("User created with id: {} and username: {}", user.getId(), user.getUsername());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        log.info("Executing AuthenticationService.authenticate()");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        log.info("User authenticated with id: {} and username: {}", user.getId(), user.getUsername());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
