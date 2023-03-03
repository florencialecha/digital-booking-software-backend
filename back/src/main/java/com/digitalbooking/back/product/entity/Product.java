package com.digitalbooking.back.product.entity;

import com.digitalbooking.back.category.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")

@NoArgsConstructor
@Getter
@Setter

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
//    private Category category;

    @Column(name = "adress")
//    private Adress adress;
    private String adress;

    @Column(name = "image")
//    private List<Image> imageList;
    private String imageList;

    @Column(name = "description")
    private String description;

    @Column(name = "availability")
    private String availability;

    @Column(name = "policies")
    private String policies;

}
