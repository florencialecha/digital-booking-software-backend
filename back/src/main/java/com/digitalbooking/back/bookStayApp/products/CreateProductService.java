package com.digitalbooking.back.bookStayApp.products;


import com.digitalbooking.back.management.categories.Category;
import com.digitalbooking.back.management.categories.CategoryRepository;
import com.digitalbooking.back.management.categories.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void handle(Product product) throws BadRequestException {
        productRepository.save(product);
    }

}
