package com.digitalbooking.back.controller;

import com.digitalbooking.back.entity.Category;
import com.digitalbooking.back.exception.ResourceNotFoundException;
import com.digitalbooking.back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/searchByCategory")

public class SearchByCategoryController {

    private CategoryService categoryService;

    @Autowired
    public SearchByCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{title}")
    public ResponseEntity<Optional<List<Category>>> searchByCategory(@PathVariable String title) throws ResourceNotFoundException {
        Optional<List<Category>> searchResult = categoryService.findByTitle(title);
        if (searchResult.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a category who does not exist in the database.");
        }
        return ResponseEntity.status(200).body(searchResult);
    }

}
