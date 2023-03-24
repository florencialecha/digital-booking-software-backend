package com.digitalbooking.back.management.users;

import com.digitalbooking.back.bookStayApp.products.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    public void handle(User user) throws BadRequestException {
        userRepository.save(user);
    }
}
