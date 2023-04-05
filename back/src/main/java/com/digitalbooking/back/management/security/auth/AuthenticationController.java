package com.digitalbooking.back.management.security.auth;

import com.digitalbooking.back.management.security.config.JwtService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin("*")

public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        log.info("Request received on AuthenticationController");

        //Validating user data
        if (
                StringUtils.isBlank(request.getFirstname()) ||
                StringUtils.isBlank(request.getLastName()) ||
                StringUtils.isBlank(request.getUsername()) ||
                StringUtils.isBlank(request.getEmail()) ||
                StringUtils.isBlank(request.getPassword())) {
            return ResponseEntity.badRequest().body("All fields are required");
        }
        if (!EmailValidator.getInstance().isValid(request.getEmail())) {
            return ResponseEntity.badRequest().body("Invalid email address");
        }
        if (request.getPassword().length() < 6) {
            return ResponseEntity.badRequest().body("Password must be at least 6 characters");
        }
        AuthenticationResponse response = authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //todo: cambiar a endpoint login
    //todo: separar controladores
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        log.info("Request received on AuthenticationController");
        AuthenticationResponse response = authenticationService.authenticate(request);
        return ResponseEntity.ok(response);
    }
}
