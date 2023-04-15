package com.digitalbooking.back.management.categories.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Data transfer object for create a new category
@Getter
@Setter
@NoArgsConstructor
public class CategoryToCreateDTO {
        private String title;
        private String description;
        private String quantity;
        private String imageUrl;
}
