package com.digitalbooking.back.management.categories.controller;

import com.digitalbooking.back.management.categories.exception.ResourceNotFoundException;
import com.digitalbooking.back.management.categories.service.DeleteCategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
@Log4j2
public class DeleteCategoryDeleteController {

    @Autowired
    private DeleteCategoryService deleteCategoryService;

    @DeleteMapping("/{id}")
    public void handle(@PathVariable Long id) throws ResourceNotFoundException {
        log.info("Request recieved on DeleteCategoryDeleteController");

        try {
            // Delete the category using the deleteCategoryService
            deleteCategoryService.handle(id);
            log.info("Response sent from DeleteCategoryDeleteController");

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting category", e);
        }
    }
}
