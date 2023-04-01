package com.digitalbooking.back.management.categories.controller;

import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import com.digitalbooking.back.bookStayApp.reserves.dto.CategoryToFindDTO;
import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.service.FindAllCategoryService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
@Log4j2
public class FindAllCategoryGetController {

    @Autowired
    private FindAllCategoryService findAllCategoryService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CategoryToFindDTO>> handle() {
        log.info("Request received on FindAllCategoryGetController");

        // Retrieve all categories using the findAllCategoryService
        List<Category> categories = findAllCategoryService.handle();

        //TODO: Esta excepción es correcto manejarlo así? debería se una excep. o sólo un aviso?
        if (categories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Map the categories to CategoryToFindDTO using the modelMapper object
        List<CategoryToFindDTO> categoryToFindDTOS = categories.stream()
                .map(category -> {
                    // Map the category entity to CategoryToFindDTO
                    CategoryToFindDTO categoryToFindDTO = modelMapper.map(category, CategoryToFindDTO.class);

                    // Return the categories as a list of CategoryToFindDTO
                    return categoryToFindDTO;
                })
                .collect(Collectors.toList());

        log.info("Response sent from FindAllCategoryGetController");
        return ResponseEntity.ok(categoryToFindDTOS);
    }
}
