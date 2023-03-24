package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.policies.PolicyDTO;
import com.digitalbooking.back.bookStayApp.address.AddressToFindDTO;
import com.digitalbooking.back.management.features.FeatureDTO;
//import com.digitalbooking.back.bookStayApp.images.ImageDTO;
//import com.digitalbooking.back.bookStayApp.reserves.ReserveToFindDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductWithDetailsToFindDTO {

    private Long id;
    private String title;
    private AddressToFindDTO address;
    private String description;
    private Integer stars;
    private Integer scoring;
    private String review;
    private String category;
    private PolicyDTO policy;
    private List<FeatureDTO> features;
//    private List<ImageDTO> images;

//    private Set<ReserveToFindDTO> reserve;

}
