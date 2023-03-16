package com.digitalbooking.back.bookStay.products.controller;

import com.digitalbooking.back.bookStay.products.entity.Product;
import com.digitalbooking.back.bookStay.products.service.CreateProductService;
import com.digitalbooking.back.management.categories.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class CreateProductPostController {

    @Autowired
    private CreateProductService createProductService;

    @PostMapping
    public void handle(@RequestBody Product product) {
        try {
            createProductService.handle(product);
            log.info("Category created successfully");
        } catch (BadRequestException e) {
            log.error("Bad Request Exception: {}", e.getMessage());
        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
        }
    }

}
