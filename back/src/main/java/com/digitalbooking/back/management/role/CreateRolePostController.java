//package com.digitalbooking.back.management.role;
//
//import lombok.extern.log4j.Log4j2;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/role")
//@CrossOrigin("*")
//@Log4j2
//
//public class CreateRolePostController {
//
//    @Autowired
//    ModelMapper modelMapper = new ModelMapper();
//    @Autowired
//    private CreateRoleService createRoleService;
//
//    @PostMapping
//    public void handle(@RequestBody RoleToCreateDTO roleToCreateDTO) {
//        try {
//            Role role = modelMapper.map(roleToCreateDTO, Role.class);
//            createRoleService.handle(role);
//        } catch (Exception e) {
//            log.error("Error creating role", e);
//        }
//    }
//}
