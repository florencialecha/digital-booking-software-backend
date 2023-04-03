//package com.digitalbooking.back.management.users.dto;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//
//public class UserToCreateDTO {
//    @NotBlank(message = "Name is required")
//    private String name;
//    @NotBlank(message = "Last name is required")
//    private String lastName;
//    @NotBlank(message = "Username is required")
//    private String username;
//    @Email(message = "Invalid email address")
//    @NotBlank(message = "Email is required")
//    private String email;
//    @Size(min = 6, message = "Password must be at least 6 characters")
//    @NotBlank(message = "Password is required")
//    private String password;
//
//}
