package com.digitalbooking.back.bookStayApp.products.domain;

import com.digitalbooking.back.bookStayApp.address.domain.Address;
import com.digitalbooking.back.management.categories.Category;
import com.digitalbooking.back.bookStayApp.policies.domain.Policy;

import com.digitalbooking.back.management.features.Feature;
import com.digitalbooking.back.bookStayApp.images.domain.Image;

import com.digitalbooking.back.bookStayApp.reserves.domain.Reserve;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// The Product class represents a product that can be booked on the platform. It contains
// information such as the title, address, description, rating, category, policy, and features
// associated with the product. It also has relationships with other entities, such as images
// and reserves. This class is annotated with JPA annotations (not hibernate annotations) to map it to the corresponding
// database table.

@Entity
@Table(name = "PRODUCT")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STARS")
    private Integer stars;

    @Column(name = "SCORING")
    private Integer scoring;

    @Column(name = "REVIEW")
    private String review;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "POLICY_ID")
    private Policy policy;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCT_FEATURE")
    private Set<Feature> features = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
          mappedBy = "product",
          cascade = CascadeType.ALL,
          orphanRemoval = true)
    private Set<Reserve> reserves = new HashSet<>();

}
