package com.digitalbooking.back.bookStayApp.products.service;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.domain.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class FindProductsByCategoryIdService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> handle(Long categoryId) {
        log.info("Executing FindProductsByCategoryIdService.handle()");
        List<Product> products = productRepository.findByCategoryId(categoryId);
        log.info("Found {} products", products.size());
        return products;
    }
}
