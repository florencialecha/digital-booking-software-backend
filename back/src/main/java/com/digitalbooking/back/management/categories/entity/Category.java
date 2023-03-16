package com.digitalbooking.back.management.categories.entity;

import com.digitalbooking.back.bookStay.products.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "QUANTITY")
    private String quantity;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @JsonIgnore
    @OneToMany
    private Set<Product> productList = new HashSet<Product>();

}
