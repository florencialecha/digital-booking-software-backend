//package com.digitalbooking.back.bookStay.images;
//import com.digitalbooking.back.bookStay.products.Product;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "image")
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//
//public class Image {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "image_id")
//    private Long id;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "imageUrl")
//    private String imageUrl;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//}
