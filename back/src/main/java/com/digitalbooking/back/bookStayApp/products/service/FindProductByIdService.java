package com.digitalbooking.back.bookStayApp.products.service;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.domain.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class FindProductByIdService {
    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> handle(Long id) {
        log.info("Executing FindProductByIdService.handle()");
        Optional<Product> product = productRepository.findById(id);
        log.info("Found product with title: {} ", product.get().getTitle());
        return product;
    }
}
