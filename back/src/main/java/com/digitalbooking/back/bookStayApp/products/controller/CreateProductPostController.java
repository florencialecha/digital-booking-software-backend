package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.products.dto.ProductToCreateDTO;
import com.digitalbooking.back.bookStayApp.products.service.CreateProductService;
import com.digitalbooking.back.bookStayApp.products.domain.Product;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<?> handle(@RequestBody ProductToCreateDTO productToCreateDTO) {
        log.info("Request received on ProductController");
        //Validate product data
        if (
                StringUtils.isBlank(productToCreateDTO.getTitle()) ||
                StringUtils.isBlank(productToCreateDTO.getAddress().getStreet()) ||
                StringUtils.isBlank(productToCreateDTO.getAddress().getNumber()) ||
                productToCreateDTO.getAddress().getCity() == null ||
                productToCreateDTO.getCategory() == null
        ) {
            return ResponseEntity.badRequest().body("Name is required");
        }


        try {
            // Map DTO to Product entity with ModelMapper
            Product product = modelMapper.map(productToCreateDTO, Product.class);

            // Handle creation of the product using the createProductService
            createProductService.handle(product, productToCreateDTO);
            log.info("Response sent from ProductController");
            return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating product", e);
        }
    }
}