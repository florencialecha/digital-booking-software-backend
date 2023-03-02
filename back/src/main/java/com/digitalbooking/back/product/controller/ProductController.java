package com.digitalbooking.back.product.controller;

import com.digitalbooking.back.category.entity.Category;
import com.digitalbooking.back.category.exception.ResourceNotFoundException;
import com.digitalbooking.back.product.entity.Product;
import com.digitalbooking.back.product.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")

@AllArgsConstructor
@NoArgsConstructor

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }



}

