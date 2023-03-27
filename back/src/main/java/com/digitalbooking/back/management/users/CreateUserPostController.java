package com.digitalbooking.back.management.users;

import com.digitalbooking.back.management.role.Role;
import com.digitalbooking.back.management.role.RoleRepository;
import io.micrometer.common.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.validator.routines.EmailValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@Log4j2

public class CreateUserPostController {

    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CreateUserService createUserService;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public ResponseEntity<?> handle(@RequestBody UserToCreateDTO userToCreateDTO) {
        try {
            // Validar datos del usuario
            if (StringUtils.isBlank(userToCreateDTO.getName()) || StringUtils.isBlank(userToCreateDTO.getLastName())
                    || StringUtils.isBlank(userToCreateDTO.getEmail()) || StringUtils.isBlank(userToCreateDTO.getPassword())) {
                return ResponseEntity.badRequest().body("All fields are required");
            }
            if (!EmailValidator.getInstance().isValid(userToCreateDTO.getEmail())) {
                return ResponseEntity.badRequest().body("Invalid email address");
            }

            User user = modelMapper.map(userToCreateDTO, User.class);

            // Encriptar contraseña antes de guardarla
            user.setPassword(userToCreateDTO.getPassword());

            // Asignar rol por id
            Role role = roleRepository.findById(userToCreateDTO.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            user.setRole(role);

            createUserService.handle(user);
            log.info("User created");
            // Develover código de estado 201 (CREATED)
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            log.error("Error creating user", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }
}

