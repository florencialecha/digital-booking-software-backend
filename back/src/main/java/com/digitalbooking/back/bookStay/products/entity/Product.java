package com.digitalbooking.back.bookStay.products.entity;
import com.digitalbooking.back.management.categories.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @Column(name = "stars")
    private Integer stars;

    @Column(name = "scoring")
    private Integer scoring;

    @Column(name = "review")
    private String review;

    //LAS CATEGORÍAS DEBEN CREARSE Y GUARDARSE PREVIAMENTE EN LA DB DE CATEGORÍAS
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    // LAS DIRECCIONES DEBEN PODER CREARSE Y GUARDARSE AL CREAR EL PRODUCTO, PASANDOLE LA CIUDAD (STRING QUE FINDCITYBYNAME)
//    @ManyToOne
//    @JoinColumn(name = "ADDRESS_ID")
//    private Address address;
//
//    @OneToMany
//    private List<Image> imageList = new ArrayList<>();
//
//    @OneToMany
//    private List<Feature> featureList = new ArrayList<>();
//
//    // Quiero crear la política, es decir, pasarle el texto, etc, cuando creo el producto.
//    @OneToOne
//    private Policy policy;

}
