package com.digitalbooking.back.bookStayApp.products;

import com.digitalbooking.back.bookStayApp.images.ImageDTO;
import com.digitalbooking.back.bookStayApp.policies.PolicyDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


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
    private Long category;
    private Set<Long> features;
    private PolicyDTO policy;
    private List<ImageDTO> images;

}
