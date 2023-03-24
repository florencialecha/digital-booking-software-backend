package com.digitalbooking.back.management.role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class RoleToCreateDTO {

    private Long id;
    private String name;
    private String description;

}
