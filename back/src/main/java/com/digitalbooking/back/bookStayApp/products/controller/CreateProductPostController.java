package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.address.domain.Address;
import com.digitalbooking.back.bookStayApp.address.dto.AddressToCreateDTO;
import com.digitalbooking.back.bookStayApp.images.domain.Image;
import com.digitalbooking.back.bookStayApp.images.dto.ImageToCreateDTO;
import com.digitalbooking.back.bookStayApp.images.domain.ImageRepository;
import com.digitalbooking.back.bookStayApp.policies.domain.Policy;
import com.digitalbooking.back.bookStayApp.policies.dto.PolicyToCreateDTO;
import com.digitalbooking.back.bookStayApp.policies.domain.PolicyRepository;
import com.digitalbooking.back.bookStayApp.products.dto.ProductToCreateDTO;
import com.digitalbooking.back.bookStayApp.products.service.CreateProductService;
import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.domain.CategoryRepository;
import com.digitalbooking.back.management.features.domain.Feature;
import com.digitalbooking.back.management.features.domain.FeatureRepository;
import com.digitalbooking.back.bookStayApp.address.domain.AddressRepository;

import com.digitalbooking.back.management.locations.domain.City;
import com.digitalbooking.back.management.locations.domain.CityRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class CreateProductPostController {
    @Autowired
    private CreateProductService createProductService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public void handle(@RequestBody ProductToCreateDTO productToCreateDTO) {
        log.info("Request received on ProductController");

        try {
            // Map DTO to Product entity with ModelMapper
            Product product = modelMapper.map(productToCreateDTO, Product.class);

            // Handle creation of the product using the createProductService
            createProductService.handle(product, productToCreateDTO);
            log.info("Response sent from ProductController");

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating product", e);
        }
    }
}