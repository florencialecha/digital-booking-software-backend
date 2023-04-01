//package com.digitalbooking.back.management.categories.controller;
//
//import com.digitalbooking.back.management.categories.domain.Category;
//import com.digitalbooking.back.management.categories.exception.BadRequestException;
//import com.digitalbooking.back.management.categories.exception.ResourceNotFoundException;
//import com.digitalbooking.back.management.categories.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/category")
//@CrossOrigin("*")
//
//public class CategoryController {
//
//

//
//    @PutMapping
//    public void update(@RequestBody Category category) throws ResourceNotFoundException, BadRequestException {
//        Optional<Category> result = categoryService.findById(category.getId());
//        if (result.isEmpty()) {
//            throw new ResourceNotFoundException("Can't update a category who does not exist in the database.");
//        }
//        categoryService.update(category);
//    }
//
