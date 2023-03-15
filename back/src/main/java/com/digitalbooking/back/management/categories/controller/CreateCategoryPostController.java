package com.digitalbooking.back.management.categories.controller;

import com.digitalbooking.back.management.categories.entity.Category;
import com.digitalbooking.back.management.categories.exception.BadRequestException;
import com.digitalbooking.back.management.categories.service.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
@Log4j2

public class CreateCategoryPostController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void handle(@RequestBody Category category) {
        try {
            categoryService.create(category);
            log.info("Category created successfully");
        } catch (BadRequestException e) {
            log.error("Bad Request Exception: {}", e.getMessage());
        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
        }
    }
}
