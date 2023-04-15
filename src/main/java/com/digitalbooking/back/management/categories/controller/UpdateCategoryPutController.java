package com.digitalbooking.back.management.categories.controller;

import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.dto.CategoryToUpdateDTO;
import com.digitalbooking.back.management.categories.exception.BadRequestException;
import com.digitalbooking.back.management.categories.exception.ResourceNotFoundException;
import com.digitalbooking.back.management.categories.service.UpdateCategoryService;
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
public class UpdateCategoryPutController {

    @Autowired
    private UpdateCategoryService updateCategoryService;
    @Autowired
    private ModelMapper modelMapper;

    @PutMapping
    public void handle(@RequestBody CategoryToUpdateDTO categoryToUpdateDTO) throws ResourceNotFoundException, BadRequestException {
        log.info("Request recieved on UpdateCategoryPutController");

        try {
            // Map DTO to Category entity with ModelMapper
            Category category = modelMapper.map(categoryToUpdateDTO, Category.class);

            // Update the category using the updateCategoryService
            updateCategoryService.handle(category);
            log.info("Response sent from UpdateCategoryPutController");

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating category", e);
        }
    }
}
