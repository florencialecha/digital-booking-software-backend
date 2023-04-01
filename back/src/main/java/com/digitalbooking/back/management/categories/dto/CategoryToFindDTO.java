package com.digitalbooking.back.management.categories.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Data Transfer Object used to find a category
@Getter
@Setter
@NoArgsConstructor
public class CategoryToFindDTO {
    private String title;
    private String description;
    private String quantity;
    private String imageUrl;
}
