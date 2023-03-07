package com.digitalbooking.back.apiProduct.entity;
import com.digitalbooking.back.apiCategory.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @OneToMany
    private List<com.digitalbooking.back.product.entity.Image> imageList = new ArrayList<>();

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AVAILABILITY")
    private String availability;

    @Column(name = "POLICIES")
    private String policies;

}
