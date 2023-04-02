package com.digitalbooking.back.bookStayApp.address.domain;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.management.locations.domain.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "NUMBER")
    private String number;

    //@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CITY_ID")
    private City city;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Product product;

}
