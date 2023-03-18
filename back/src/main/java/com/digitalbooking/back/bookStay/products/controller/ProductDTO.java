package com.digitalbooking.back.bookStay.products.controller;

import com.digitalbooking.back.bookStay.address.AddressDTO;

import com.digitalbooking.back.management.categories.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class ProductDTO {

    private String title;
    private String description;
    private Integer stars;
    private Integer scoring;
    private String review;

    //Quiero pasarle sólo el id de category
    private Long categoryId;
    private AddressDTO address;

}
