package com.digitalbooking.back.bookStay.products.service;

import com.digitalbooking.back.bookStay.products.entity.Product;
import com.digitalbooking.back.bookStay.products.repository.ProductRepository;
import com.digitalbooking.back.management.categories.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {

    @Autowired
    private ProductRepository productRepository;

    public void handle(Product product) throws BadRequestException {
        productRepository.save(product);
    }

}
