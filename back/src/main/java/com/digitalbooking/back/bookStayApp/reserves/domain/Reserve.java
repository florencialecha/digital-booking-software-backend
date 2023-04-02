package com.digitalbooking.back.bookStayApp.reserves.domain;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
//import com.digitalbooking.back.management.users.domain.User;
import com.digitalbooking.back.management.users.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "RESERVE")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVE_ID")
    private Long id;

    @Column(name = "START_TIME", nullable = false)
    private LocalTime startTime;

    @Column(name = "CHECK_IN", nullable = false)
    private LocalDate checkIn;

    @Column(name = "CHECK_OUT", nullable = false)
    private LocalDate checkOut;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;

}
