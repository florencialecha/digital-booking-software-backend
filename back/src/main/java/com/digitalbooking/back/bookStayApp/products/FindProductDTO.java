package com.digitalbooking.back.bookStayApp.products;

import com.digitalbooking.back.bookStayApp.address.FindAddressDTO;
import com.digitalbooking.back.bookStayApp.images.ImageDTO;
import com.digitalbooking.back.management.categories.CategoryDTO;
import com.digitalbooking.back.management.features.FeatureDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FindProductDTO {

    private Long id;
    private String title;
    private String description;
    private Integer stars;
    private Integer scoring;
    private String review;
    private CategoryDTO category;
    private List<FeatureDTO> features;
    private List<ImageDTO> images;
    private FindAddressDTO address;

}
