package com.digitalbooking.back.management.users;

import com.digitalbooking.back.management.role.RoleToCreateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserToCreateDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Long role;

}
