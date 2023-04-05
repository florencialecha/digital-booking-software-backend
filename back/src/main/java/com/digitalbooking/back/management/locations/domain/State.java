package com.digitalbooking.back.management.locations.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STATE")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "state",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<City> cities = new HashSet<>();

}
