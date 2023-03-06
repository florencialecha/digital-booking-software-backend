package com.digitalbooking.back.apiCity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COUNTRY")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany
    private List<State> states = new ArrayList<>();

}
