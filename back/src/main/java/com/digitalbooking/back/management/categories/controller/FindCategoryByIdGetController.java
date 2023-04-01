package com.digitalbooking.back.management.categories.controller;

import com.digitalbooking.back.bookStayApp.reserves.dto.CategoryToFindDTO;
import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.exception.ResourceNotFoundException;
import com.digitalbooking.back.management.categories.service.FindCategoryByIdService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
@Log4j2
public class FindCategoryByIdGetController {

    @Autowired
    private FindCategoryByIdService findCategoryByIdService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("{id}")
    public ResponseEntity<CategoryToFindDTO> handle(@PathVariable Long id) throws ResourceNotFoundException {
        log.info("Request received on FindCategoryByIdGetController with id {} ", id);

        Optional<Category> categoryOptional = findCategoryByIdService.handle(id);

        // If the category is not found, throw an exception
        Category category = categoryOptional.orElseThrow(() ->
                new ResourceNotFoundException("Don't find any category with id: " + id + ". Try again.")
        );

        // Map the category (domain object) to CategoryToFindDTO
        CategoryToFindDTO categoryToFindDTO = modelMapper.map(category, CategoryToFindDTO.class);

        log.info("Response sent from FindCategoryByIdGetController");
        return ResponseEntity.ok(categoryToFindDTO);
    }

}
