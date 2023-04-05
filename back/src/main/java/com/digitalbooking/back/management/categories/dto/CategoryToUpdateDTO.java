package com.digitalbooking.back.management.categories.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryToUpdateDTO {
    private Long id;
    private String title;
    private String description;
    private String quantity;
    private String imageUrl;
}
