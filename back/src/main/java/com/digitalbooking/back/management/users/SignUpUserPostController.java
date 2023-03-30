package com.digitalbooking.back.management.users;


import com.digitalbooking.back.management.authority.AuthorityRepository;
import io.micrometer.common.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.validator.routines.EmailValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
@Log4j2

public class SignUpUserPostController {

    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CreateUserService createUserService;
    @Autowired
    private AuthorityRepository authorityRepository;

    @PostMapping("sign_up")
    public ResponseEntity<?> handle(@RequestBody UserToCreateDTO userToCreateDTO) {
        log.info("Creating user");
        try {
            // Validar datos del usuario
            if (
                    StringUtils.isBlank(userToCreateDTO.getName()) ||
                    StringUtils.isBlank(userToCreateDTO.getLastName()) ||
                    StringUtils.isBlank(userToCreateDTO.getUsername()) ||
                    StringUtils.isBlank(userToCreateDTO.getEmail()) ||
                    StringUtils.isBlank(userToCreateDTO.getPassword()))
            {
                return ResponseEntity.badRequest().body("All fields are required");
            }
            if (!EmailValidator.getInstance().isValid(userToCreateDTO.getEmail())) {
                return ResponseEntity.badRequest().body("Invalid email address");
            }
            if (userToCreateDTO.getPassword().length() < 6) {
                return ResponseEntity.badRequest().body("Password must be at least 6 characters");
            }

            log.info("User data validated. Initializing user creation");
            // Mapear datos del usuario del dto a una entidad user
            User user = modelMapper.map(userToCreateDTO, User.class);

            // Crear usuario
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

