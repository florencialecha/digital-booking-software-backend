package com.digitalbooking.back.management.categories.service;

import com.digitalbooking.back.management.categories.entity.Category;
import com.digitalbooking.back.management.categories.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindCategoryByIdService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> handle(Long id) {
        return categoryRepository.findById(id);
    }

}
