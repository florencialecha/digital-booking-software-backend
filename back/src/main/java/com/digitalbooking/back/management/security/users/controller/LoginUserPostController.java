//package com.digitalbooking.back.management.users;
//
//import com.digitalbooking.back.management.authority.Authority;
//import com.digitalbooking.back.security.AuthenticationRequest;
//import com.digitalbooking.back.security.CustomAuthentication;
//import com.digitalbooking.back.security.SecurityAuthority;
//import com.digitalbooking.back.utils.JwtUtil;
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//
//// This controller handles login (POST) requests and returns a JWT to the authenticated user.
//// It authenticates the user using the AuthenticationManager and, if successful, generates a JWT using
//// the JwtUtil class. The response includes the JWT that the client must send in subsequent requests
//// to access protected resources.
//
//@RestController
//@RequestMapping
//@CrossOrigin("*")
//@Log4j2
//
//@AllArgsConstructor
//public class LoginUserPostController {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//    private final UserService userService;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody AuthenticationRequest authenticationRequest) {
//        log.info("Starting authentication process for user: {}", authenticationRequest.getUsername());
//
//        // Load user details by username
//        UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
//
//        // Create a custom Authentication object that wraps the userDetails and authorities
//        Collection<SecurityAuthority> authorities = userDetails.getAuthorities().stream()
//                .map(authority -> new SecurityAuthority((Authority) authority))
//                .collect(Collectors.toList());
//
//        Authentication customAuthentication = new CustomAuthentication(userDetails, authorities);
//
//        // Authenticate the user using the AuthenticationManager
//        Authentication authentication = authenticationManager.authenticate(customAuthentication);
//
//        // If authentication is successful, get the UserDetails object from the Authentication object
//        UserDetails authenticatedUserDetails = (UserDetails) authentication.getPrincipal();
//        log.info("Successful authentication for user: {}", authenticatedUserDetails.getUsername());
//
//        // Generate a JWT using the JwtUtil class and the UserDetails object
//        String jwt = jwtUtil.generateToken(authenticatedUserDetails);
//        log.info("Generated JWT for user: {}", authenticatedUserDetails.getUsername());
//
//        // Return the JWT in the HTTP response
//        return ResponseEntity.status(HttpStatus.OK).body(jwt);
//    }
//}
