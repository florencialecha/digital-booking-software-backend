package com.digitalbooking.back.management.locations.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CITY")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "STATE_ID")
    private State state;

}
