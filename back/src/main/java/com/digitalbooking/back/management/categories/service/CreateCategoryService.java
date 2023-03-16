package com.digitalbooking.back.management.categories.service;

import com.digitalbooking.back.management.categories.entity.Category;
import com.digitalbooking.back.management.categories.exception.BadRequestException;
import com.digitalbooking.back.management.categories.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void handle(Category category) throws BadRequestException {
        categoryRepository.save(category);
    }

}
