package com.digitalbooking.back.management.categories.controller;

import com.digitalbooking.back.management.categories.entity.Category;
import com.digitalbooking.back.management.categories.exception.BadRequestException;
import com.digitalbooking.back.management.categories.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")


public class CreateCategoryPostController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void create(@RequestBody Category category) throws BadRequestException {
        categoryService.create(category);
    }

}
