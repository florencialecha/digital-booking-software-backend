//package com.digitalbooking.back.management.users.service;
//
//import com.digitalbooking.back.management.users.domain.User;
//import com.digitalbooking.back.management.users.domain.UserRepository;
//import com.digitalbooking.back.management.users.exception.UsernameNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public void handle(User user) {
//        userRepository.save(user);
//    }
//
//    public User findByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//
//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//}