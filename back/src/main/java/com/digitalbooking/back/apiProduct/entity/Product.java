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

    // LAS CATEGORÍAS DEBEN CREARSE Y GUARDARSE PREVIAMENTE EN LA DB DE CATEGORÍAS
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    // LAS DIRECCIONES DEBEN PODER CREARSE Y GUARDARSE AL CREAR EL PRODUCTO, PASANDOLE LA CIUDAD (STRING QUE FINDCITYBYNAME)
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @OneToMany
    private List<Image> imageList = new ArrayList<>();

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany
    private List<Feature> featureList = new ArrayList<>();

    @Column(name = "AVAILABILITY")
    private String availability;

    // Quiero crear la política, es decir, pasarle el texto, etc, cuando creo el producto.
    @OneToOne
    private Policy policy;

}
