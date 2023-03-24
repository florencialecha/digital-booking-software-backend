package com.digitalbooking.back.management.features;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FEATURE")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEATURE_ID")
    private Long id;

    @Column(name = "NAME")
    private String title;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "features")
    private Set<Product> products = new HashSet<>();

}
