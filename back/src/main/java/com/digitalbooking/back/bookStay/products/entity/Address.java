//package com.digitalbooking.back.bookStay.products.entity;
//
//import com.digitalbooking.back.management.cities.entity.City;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "ADDRESS")
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//
//public class Address {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ADDRESS_ID")
//    private Long id;
//
//    @Column(name = "STREET")
//    private String street;
//
//    @Column(name = "NUMBER")
//    private String number;
//
//    @ManyToOne
//    @JoinColumn(name = "CITY_ID")
//    private City city;
//
//}
