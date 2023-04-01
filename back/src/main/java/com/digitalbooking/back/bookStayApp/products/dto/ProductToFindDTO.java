package com.digitalbooking.back.bookStayApp.products.dto;

import com.digitalbooking.back.bookStayApp.address.dto.AddressToFindDTO;
import com.digitalbooking.back.management.features.FeatureDTO;
import com.digitalbooking.back.bookStayApp.images.dto.ImageDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// Data transfer object used for finding a Product
@Getter
@Setter
@NoArgsConstructor
public class ProductToFindDTO {

    private Long id;
    private String title;
    private AddressToFindDTO address;
    private String description;
    private Integer stars;
    private Integer scoring;
    private String review;
    private String category;
    private List<FeatureDTO> features;
    private List<ImageDTO> images;

}
