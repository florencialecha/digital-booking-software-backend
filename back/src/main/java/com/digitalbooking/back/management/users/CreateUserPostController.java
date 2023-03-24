//package com.digitalbooking.back.management.users;
//
//import com.digitalbooking.back.management.role.Role;
//import com.digitalbooking.back.management.role.RoleRepository;
//import lombok.extern.log4j.Log4j2;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.awt.*;
//
//@RestController
//@RequestMapping("/user")
//@CrossOrigin("*")
//@Log4j2
//
//public class CreateUserPostController {
//
//    @Autowired
//    ModelMapper modelMapper = new ModelMapper();
//    @Autowired
//    private CreateUserService createUserService;
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @PostMapping
//    public void handle(@RequestBody UserToCreateDTO userToCreateDTO) {
//        try {
//            User user = modelMapper.map(userToCreateDTO, User.class);
//            // Asignar rol por id
//            Role role = roleRepository.findById(userToCreateDTO.getRole())
//                    .orElseThrow(() -> new RuntimeException("Role not found"));
//            user.setRole(role);
//            createUserService.handle(user);
//        } catch (Exception e) {
//            log.error("Error creating user", e);
//        }
//    }
//}
