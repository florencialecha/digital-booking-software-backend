package com.digitalbooking.back.controller;

import com.digitalbooking.back.entity.Category;
import com.digitalbooking.back.exception.BadRequestException;
import com.digitalbooking.back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saveCategory")

public class SaveCategoryController {

    private CategoryService categoryService;

    @Autowired
    public SaveCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void save(@RequestBody Category category) throws BadRequestException {
        categoryService.save(category);
    }
}
