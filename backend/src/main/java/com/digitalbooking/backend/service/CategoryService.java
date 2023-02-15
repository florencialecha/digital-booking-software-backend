package com.digitalbooking.backend.service;

import com.digitalbooking.backend.entity.Category;
import com.digitalbooking.backend.exception.BadRequestException;
import com.digitalbooking.backend.exception.ResourceNotFoundException;
import com.digitalbooking.backend.repository.CategoryRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryService {

    private CategoryRepository categoryRepository;
    private final Logger LOGGER = Logger.getLogger(CategoryService.class);

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        LOGGER.info("We have received your request. Please wait.");
        categoryRepository.save(category);
        LOGGER.info("Order completed. We are sending the result.");
        return category;
    }

    public Optional<Category> findById(Long id) throws ResourceNotFoundException {
        LOGGER.info("We have received your request. Please wait.");
        return categoryRepository.findById(id);
    }

    public List<Category> findAll() throws ResourceNotFoundException {
        LOGGER.info("We have received your request. Please wait.");
        return categoryRepository.findAll();
    }

    public void update(Category category) throws BadRequestException, ResourceNotFoundException {
        LOGGER.info("We have received your request. Please wait.");
        categoryRepository.save(category);
        LOGGER.info("Order completed. We are sending the result.");
    }

    public void deleteById(Long id) throws ResourceNotFoundException {
        LOGGER.info("We have received your request. Please wait.");
        categoryRepository.deleteById(id);
        LOGGER.info("Order completed. We are sending the result.");
    }

}
