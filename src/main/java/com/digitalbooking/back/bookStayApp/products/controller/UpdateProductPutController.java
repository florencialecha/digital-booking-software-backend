package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.dto.ProductToUpdateDTO;
import com.digitalbooking.back.bookStayApp.products.service.UpdateProductService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2
public class UpdateProductPutController {

    @Autowired
    private UpdateProductService updateProductService;
    @Autowired
    private ModelMapper modelMapper;

    @PutMapping
    public void handle(@RequestBody ProductToUpdateDTO productToUpdateDTO) {
        log.info("Request received on UpdateProductPutController");

        try {
            // Handle update of the product using the updateProductService
            updateProductService.handle(productToUpdateDTO);
            log.info("Response sent from UpdateProductPutController");

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating product", e);
        }
    }
}