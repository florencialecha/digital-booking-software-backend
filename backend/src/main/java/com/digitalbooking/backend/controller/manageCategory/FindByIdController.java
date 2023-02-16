package com.digitalbooking.backend.controller.manageCategory;

import com.digitalbooking.backend.entity.Category;
import com.digitalbooking.backend.exception.ResourceNotFoundException;
import com.digitalbooking.backend.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/findCategory")

public class FindByIdController {

    private CategoryService categoryService;
    private final Logger LOGGER = Logger.getLogger(FindByIdController.class);

    @Autowired
    public FindByIdController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/byId")
    public ResponseEntity<Optional<Category>> findById(@RequestParam Long id) throws ResourceNotFoundException {
        LOGGER.info("Request send: you are trying to find a Category.");
        Optional<Category> searchCategory = categoryService.findBy(id);
        if (searchCategory.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a category who does not exist in the database.");
        }
        return ResponseEntity.status(200).body(searchCategory);
    }


}
