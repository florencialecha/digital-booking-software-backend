package com.digitalbooking.back.bookStayApp.products;

import com.digitalbooking.back.bookStayApp.images.Image;
import com.digitalbooking.back.bookStayApp.policies.Policy;
import com.digitalbooking.back.bookStayApp.reserves.Reserve;
import com.digitalbooking.back.management.categories.Category;
import com.digitalbooking.back.management.features.Feature;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCT_FEATURE",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "FEATURE_ID")})
    private Set<Feature> features = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "POLICY_ID")
    private Policy policy;

    @OneToMany(fetch = FetchType.EAGER,
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
