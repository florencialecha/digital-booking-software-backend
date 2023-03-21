package com.digitalbooking.back.bookStayApp.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindProductsRandomService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> handle() {
        return productRepository.findAll();
    }
}
