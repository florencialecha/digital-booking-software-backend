//package com.digitalbooking.back.management.categories.controller;
//
//import com.digitalbooking.back.management.categories.Category;
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
//    @Autowired
//    private CategoryService categoryService;
//
//    @GetMapping("{id}")
//    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id) throws ResourceNotFoundException {
//        Optional<Category> category = categoryService.findById(id);
//        if (category.isEmpty()) {
//            throw new ResourceNotFoundException("Don't find any category with id: " + id + ". Try again.");
//        }
//        return ResponseEntity.status(200).body(category);
//    }
//
//    @GetMapping("byName/{categoryName}")
//    public ResponseEntity<Optional<List<Category>>> findByTitle(@PathVariable String categoryName) throws ResourceNotFoundException {
//        Optional<List<Category>> result = categoryService.findByTitle(categoryName);
//        if (result.isEmpty()) {
//            throw new ResourceNotFoundException("Can't find a category who does not exist in the database.");
//        }
//        return ResponseEntity.status(200).body(result);
//    }
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
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
//        Optional<Category> result = categoryService.findById(id);
//        if (result.isEmpty()) {
//            throw new ResourceNotFoundException("Can't delete a category who does not exist in the database.");
//        }
//        categoryService.delete(id);
//    }
//
//}