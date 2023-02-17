package com.digitalbooking.back.controller;

import com.digitalbooking.back.entity.Category;
import com.digitalbooking.back.exception.BadRequestException;
import com.digitalbooking.back.exception.ResourceNotFoundException;
import com.digitalbooking.back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")

public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{title}")
    public ResponseEntity<Optional<List<Category>>> findByTitle(@PathVariable String title) throws ResourceNotFoundException {
        Optional<List<Category>> result = categoryService.findByTitle(title);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a category who does not exist in the database.");
        }
        return ResponseEntity.status(200).body(result);
    }

    @PostMapping
    public void create(@RequestBody Category category) throws BadRequestException {
        categoryService.create(category);
    }

    @PutMapping
    public void update(@RequestBody Category category) throws ResourceNotFoundException, BadRequestException {
        Optional<Category> result = categoryService.findById(category.getId());
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Can't update a category who does not exist in the database.");
        }
        categoryService.update(category);
    }

}
