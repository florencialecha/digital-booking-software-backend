package com.digitalbooking.back.bookStayApp.products.dto;

import com.digitalbooking.back.bookStayApp.address.dto.AddressToCreateDTO;
import com.digitalbooking.back.bookStayApp.images.dto.ImageToCreateDTO;
import com.digitalbooking.back.bookStayApp.policies.dto.PolicyToCreateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

// Data transfer object used for creating a new Product
@Getter
@Setter
@NoArgsConstructor
public class ProductToCreateDTO {
    private String title;
    private AddressToCreateDTO address;
    private String description;
    private Integer stars;
    private Integer scoring;
    private String review;
    private Long category;
    private PolicyToCreateDTO policy;
    private Set<Long> features;
    private List<ImageToCreateDTO> images;
}
