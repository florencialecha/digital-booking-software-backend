package com.digitalbooking.back.apiProduct.controller;

import com.digitalbooking.back.apiCategory.exception.BadRequestException;
import com.digitalbooking.back.apiCategory.exception.ResourceNotFoundException;
import com.digitalbooking.back.apiProduct.entity.Product;
import com.digitalbooking.back.apiProduct.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Product> product = productService.findById(id);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException("Don't find any product with id: " + id + ". Try again.");
        }
        return ResponseEntity.status(200).body(product);
    }

    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Product>> findByCity(@PathVariable String cityName) throws ResourceNotFoundException {
        List<Product> result = productService.findByCity(cityName);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a products on this city.");
        }
        return ResponseEntity.status(200).body(result);
    }

    @PostMapping
    public void create(@RequestBody Product product) throws BadRequestException {
        productService.create(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Product> result = productService.findById(id);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Can't delete a product who does not exist in the database.");
        }
        productService.delete(id);
    }

}

