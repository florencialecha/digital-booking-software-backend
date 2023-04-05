package com.digitalbooking.back.bookStayApp.products.service;


import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.domain.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Log4j2
public class FindAllProductsService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> handle() {
        log.info("Executing FindAllProductsService.handle()");
        List<Product> products = productRepository.findAll();
        log.info("Found {} products", products.size());
        return products;
    }
}
