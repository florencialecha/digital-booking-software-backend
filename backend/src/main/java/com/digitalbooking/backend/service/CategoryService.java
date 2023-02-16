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

    public Optional<Category> findBy(Long id) throws ResourceNotFoundException {
        LOGGER.info("We have received your request. Please wait.");
        return categoryRepository.findById(id);
    }

    public Optional<Category> findByTitle(String title) throws ResourceNotFoundException {
        LOGGER.info("We have received your request. Please wait.");
        return categoryRepository.findByTitle(title);
    }


    public List<Category> findAll() throws ResourceNotFoundException {
        LOGGER.info("We have received your request. Please wait.");
        return categoryRepository.findAll();
    }

}
