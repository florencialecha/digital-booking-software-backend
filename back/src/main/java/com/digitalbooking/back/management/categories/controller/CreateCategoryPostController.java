package com.digitalbooking.back.management.categories.controller;

import com.digitalbooking.back.management.categories.dto.CategoryToCreateDTO;
import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.exception.ResourceNotFoundException;
import com.digitalbooking.back.management.categories.service.CreateCategoryService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
@Log4j2
public class CreateCategoryPostController {

    @Autowired
    private CreateCategoryService createCategoryService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public void handle(@RequestBody CategoryToCreateDTO categoryToCreateDTO) throws ResourceNotFoundException {
        log.info("Request received on CreateCategoryPostController");

        try {
            // Map DTO to Category entity with ModelMapper
            Category category = modelMapper.map(categoryToCreateDTO, Category.class);

            // Create the category using the createCategoryService
            createCategoryService.handle(category);
            log.info("Response sent from CreateCategoryPostController");

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating category", e);
        }
    }
}
