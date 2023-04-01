//package com.digitalbooking.back.management.users;
//
//import com.digitalbooking.back.bookStayApp.products.exception.BadRequestException;
//import com.digitalbooking.back.management.authority.Authority;
//import com.digitalbooking.back.management.authority.AuthorityRepository;
//import com.digitalbooking.back.security.SecurityUser;
//import com.digitalbooking.back.utils.AuthorityName;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//@Log4j2
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private AuthorityRepository authorityRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public void handle(User user) throws BadRequestException {
//
//        //Validar que el nombre de usuario y el email no existan ya en la base de datos
//        log.info("Validating username");
//        String username = user.getUsername();
//        if (userRepository.findByUsername(username).isPresent()) {
//            throw new BadRequestException("Username already exists: " + username + ". Try another one.");
//        }
//        log.info("Username is available");
//
//        log.info("Validating email");
//        String email = user.getEmail();
//        if (userRepository.findByEmail(email).isPresent()) {
//            throw new BadRequestException("Email already exists: " + email + ". Try another one.");
//        }
//        log.info("Email is available");
//
//        // Encriptar la contraseña antes de guardarla
//        log.info("Encripting password");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        log.info("Password encripted");
//
//        //Por defecto, todos mis usuarios comienzan con ROLE_USER. Sólo un administrador puede asignarles otra autoridad extra.
//        // Cargar la autoridad ROLE_USER
//        log.info("Loading ROLE_USER");
//        Authority roleUser = authorityRepository.findByName(AuthorityName.ROLE_USER)
//                .orElseThrow(() -> new RuntimeException("Authority ROLE_USER not found"));
//        log.info("ROLE_USER loaded");
//
//        // Asignar la autoridad ROLE_USER al usuario
//        log.info("Assigning ROLE_USER to user");
//        user.setAuthorities(Collections.singletonList(roleUser));
//
//        // Guardar el usuario en la base de datos
//        log.info("Saving user");
//        userRepository.save(user);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        var user = this.userRepository.findByUsername(username);
//        if(user.isPresent()){
//            return new SecurityUser(user.get());
//        }
//        throw new UsernameNotFoundException("User not found: " + username);
//    }
//
//}
