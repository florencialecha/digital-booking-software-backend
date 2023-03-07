package com.digitalbooking.back.apiProduct.service;

import com.digitalbooking.back.apiProduct.entity.Product;
import com.digitalbooking.back.apiProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findByCity(String cityName) {
        return productRepository.findByAddressCityName(cityName);
    }

    public void create(Product product) {
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
