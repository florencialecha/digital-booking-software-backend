package com.digitalbooking.back.management.categories.service;

import com.digitalbooking.back.management.categories.entity.Category;
import com.digitalbooking.back.management.categories.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> handle() {
        return categoryRepository.findAll();
    }

}
