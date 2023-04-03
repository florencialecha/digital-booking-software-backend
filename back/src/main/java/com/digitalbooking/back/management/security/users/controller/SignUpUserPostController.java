//package com.digitalbooking.back.management.users;
//
//import com.digitalbooking.back.management.users.domain.User;
//import com.digitalbooking.back.management.users.dto.UserToCreateDTO;
//import com.digitalbooking.back.management.users.service.UserService;
//import io.micrometer.common.util.StringUtils;
//import jakarta.validation.ConstraintViolation;
//import lombok.extern.log4j.Log4j2;
//import org.apache.commons.validator.Validator;
//import org.apache.commons.validator.ValidatorResults;
//import org.apache.commons.validator.routines.EmailValidator;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping
//@CrossOrigin("*")
//@Log4j2
//
//public class SignUpUserPostController {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private ModelMapper modelMapper;
//    @Autowired
//    private Validator validator;
//
//    @PostMapping("/sign_up")
//    public ResponseEntity<?> handle(@RequestBody UserToCreateDTO userToCreateDTO) {
//        log.info("Creating user");
//        try {
//            // Validating user data
//            ValidatorResults errors = validator.validate();
//            if (!errors.isEmpty()) {
//                String errorMsg = errors.stream()
//                        .map(ConstraintViolation::getMessage)
//                        .collect(Collectors.joining(", "));
//                return ResponseEntity.badRequest().body(errorMsg);
//            }
//
//            log.info("User data validated. Initializing user creation");
//
//            // Mapping user data from DTO to entity
//            User user = modelMapper.map(userToCreateDTO, User.class);
//
//            // Creating user
//            userService.handle(user);
//            log.info("Response sent from SignUpUserPostController");
//
//            // Returning status code 201 (CREATED)
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//
//        } catch (Exception e) {
//            log.error("Error creating user", e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
//        }
//    }