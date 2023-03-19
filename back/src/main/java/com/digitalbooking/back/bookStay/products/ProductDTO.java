package com.digitalbooking.back.bookStay.products;

import com.digitalbooking.back.bookStay.address.AddressDTO;

import com.digitalbooking.back.bookStay.images.ImageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    // Quiero asignarle la categoría al crearlo
    private Long categoryId;
    private AddressDTO address;

    private List<ImageDTO> images;

}
