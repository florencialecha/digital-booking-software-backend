package com.digitalbooking.back.bookStayApp.products.controller;

//import com.digitalbooking.back.bookStayApp.address.AddressToFindDTO;
//import com.digitalbooking.back.bookStayApp.images.ImageDTO;
//import com.digitalbooking.back.management.features.FeatureDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductToFindDTO {

    private Long id;
    private String title;
    private String description;
    private Integer stars;
    private Integer scoring;
    private String review;
    private String category;
//    private List<FeatureDTO> features;
//    private List<ImageDTO> images;
//    private AddressToFindDTO address;

}
