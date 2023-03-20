package com.digitalbooking.back.bookStayApp.reserves;

import com.digitalbooking.back.bookStayApp.products.Product;
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

    //todo: verificar si los tipos de datos son correctos
    @Column(name = "START_TIME")
    private LocalTime startTime;

    //todo: verificar si los tipos de datos son correctos
    @Column(name = "START_DATE")
    private LocalDate startDate;

    //todo: verificar si los tipos de datos son correctos
    @Column(name = "END_DATE")
    private LocalDate endDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private Product product;

}
