package com.digitalbooking.back.management.role;

import com.digitalbooking.back.management.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ROLE")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;
}
