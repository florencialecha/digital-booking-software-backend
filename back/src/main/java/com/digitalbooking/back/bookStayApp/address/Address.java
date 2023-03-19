//package com.digitalbooking.back.bookStay.address;
//
//import com.digitalbooking.back.management.cities.City;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "address")
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
//    @Column(name = "address_id")
//    private Long id;
//
//    @Column(name = "street")
//    private String street;
//
//    @Column(name = "number")
//    private String number;
//
//    @ManyToOne
//    @JoinColumn(name = "city_id")
//    private City city;
//
//}
