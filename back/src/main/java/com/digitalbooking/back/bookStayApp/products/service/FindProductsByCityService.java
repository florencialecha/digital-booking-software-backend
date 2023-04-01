package com.digitalbooking.back.bookStayApp.products.service;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.domain.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class FindProductsByCityService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> handle(String cityName) {
        log.info("Executing FindProductsByCityService.handle()");
        List<Product> products = productRepository.findByAddressCityName(cityName);
        return products;
    }
}
