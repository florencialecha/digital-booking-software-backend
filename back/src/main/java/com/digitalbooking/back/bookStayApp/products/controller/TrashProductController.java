//package com.digitalbooking.back.bookStay.products.controller;
//
//import com.digitalbooking.back.bookStay.products.entity.Product;
//import com.digitalbooking.back.bookStay.products.service.ProductService;
//import com.digitalbooking.back.management.categories.exception.BadRequestException;
//import com.digitalbooking.back.management.categories.exception.ResourceNotFoundException;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//// HOLA
//@RestController
//@RequestMapping("/product")
//@CrossOrigin("*")
//
//@AllArgsConstructor
//@NoArgsConstructor
//
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping
//    public List<Product> findAll() {
//        return productService.findAll();
//    }
//
//    @GetMapping("/byCategory/{categoryId}")
//    public ResponseEntity<List<Product>> findByCategory(@PathVariable Long categoryId) throws ResourceNotFoundException {
//        List<Product> result = productService.findByCategory(categoryId);
//        if (result.isEmpty()) {
//            throw new ResourceNotFoundException("Can't find a products on this category.");
//        }
//        return ResponseEntity.status(200).body(result);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
//        Optional<Product> result = productService.findById(id);
//        if (result.isEmpty()) {
//            throw new ResourceNotFoundException("Can't delete a product who does not exist in the database.");
//        }
//        productService.delete(id);
//    }
//
//}
//
