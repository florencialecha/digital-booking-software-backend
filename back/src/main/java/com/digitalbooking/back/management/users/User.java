package com.digitalbooking.back.management.users;

import com.digitalbooking.back.bookStayApp.reserves.domain.Reserve;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "USERS")

@NoArgsConstructor
@Getter
@Setter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Reserve> reserves;

    //Cada usuario debería tener una lista de roles: ROLE_USER, ROLE_HOST, ROLE_ADMIN
    //todo: implementar roles

}
