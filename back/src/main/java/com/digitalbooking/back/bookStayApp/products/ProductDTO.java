package com.digitalbooking.back.bookStayApp.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
