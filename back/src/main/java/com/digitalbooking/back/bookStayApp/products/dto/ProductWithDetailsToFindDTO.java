package com.digitalbooking.back.bookStayApp.products.dto;

import com.digitalbooking.back.bookStayApp.policies.dto.PolicyDTO;
import com.digitalbooking.back.bookStayApp.address.dto.AddressToFindDTO;
import com.digitalbooking.back.management.features.dto.FeatureToFindDTO;
import com.digitalbooking.back.bookStayApp.images.dto.ImageDTO;
import com.digitalbooking.back.bookStayApp.reserves.dto.ReserveToFindDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

// Data transfer object used for finding a Product with additional details
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
    private List<FeatureToFindDTO> features;
    private List<ImageDTO> images;
    private Set<ReserveToFindDTO> reserve;

}
