package com.digitalbooking.back.product.entity;

import com.digitalbooking.back.apiProduct.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IMAGE")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMAGE_ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "IMAGEURL")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

}
