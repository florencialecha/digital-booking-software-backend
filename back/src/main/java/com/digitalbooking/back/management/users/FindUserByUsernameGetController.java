package com.digitalbooking.back.management.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
@Log4j2

public class FindUserByUsernameGetController {

    @GetMapping("/health-check")
    public String showHealthCheck() {
        return "Health check";
    }
}
