package com.digitalbooking.back.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ADRESS")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADRESS_ID")
    private Long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "NUMBER")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

}
