package com.digitalbooking.back.bookStay.products;

import com.digitalbooking.back.bookStay.products.Product;
import com.digitalbooking.back.bookStay.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> handle() {
        return productRepository.findAll();
    }
}
