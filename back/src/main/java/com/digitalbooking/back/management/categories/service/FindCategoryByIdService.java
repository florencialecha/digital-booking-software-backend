package com.digitalbooking.back.management.categories.service;

import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.domain.CategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class FindCategoryByIdService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Optional<Category> handle(Long id) {
        log.info("Executing FindCategoryByIdService.handle()");
        Optional<Category> category = categoryRepository.findById(id);
        log.info("Found category with id: {}", id);
        return category;
    }
}
