package com.digitalbooking.back.apiproduct.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;

    @Column(name = "adress")
    private Adress adress;

    @Column(name = "image")
    private List<Image> imageList;

    @Column(name = "description")
    private String description;

    @Column(name = "availability")
    private String availability;

    @Column(name = "policies")
    private String policies;
    
}
