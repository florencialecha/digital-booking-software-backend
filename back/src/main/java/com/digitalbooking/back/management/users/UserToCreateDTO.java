package com.digitalbooking.back.management.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserToCreateDTO {
    private String name;
    private String lastName;
    private String username;
    private String email;
    private String password;

}
