package com.digitalbooking.back.management.categories.service;

import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.domain.CategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UpdateCategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public void handle(Category category) {
       log.info("Executing UpdateCategoryService.handle()");
       categoryRepository.save(category);
         log.info("Category updated with id: {}", category.getId());
    }
}
