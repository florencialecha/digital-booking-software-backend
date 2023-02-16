package com.digitalbooking.back.controller;

import com.digitalbooking.back.entity.Category;
import com.digitalbooking.back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/searchAll")

public class SearchAllController {

    private CategoryService categoryService;

    @Autowired
    public SearchAllController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> searchAll() {
        return categoryService.searchAll();
    }
}
