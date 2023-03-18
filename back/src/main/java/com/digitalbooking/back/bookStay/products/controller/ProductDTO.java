package com.digitalbooking.back.bookStay.products.controller;

import com.digitalbooking.back.bookStay.address.AddressDTO;

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
    private AddressDTO address;

}
