package com.digitalbooking.back.management.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin("*")
@Log4j2
public class LoginUserPostController {

    @PostMapping("login")
    public ResponseEntity<String> handle() {
        log.info("Signing in user");
        return ResponseEntity.ok("User signed in: a jwt token will be returned here.");
    }

}
