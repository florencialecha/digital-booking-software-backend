package com.digitalbooking.back.management.categories;

import com.digitalbooking.back.bookStayApp.products.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, orphanRemoval = false, cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();

}
