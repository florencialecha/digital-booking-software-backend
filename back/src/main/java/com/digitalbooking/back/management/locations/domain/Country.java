package com.digitalbooking.back.management.locations.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "country",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<State> states = new HashSet<>();

}
