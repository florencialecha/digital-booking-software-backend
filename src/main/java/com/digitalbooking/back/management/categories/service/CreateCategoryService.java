package com.digitalbooking.back.management.categories.service;

import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.domain.CategoryRepository;
import com.digitalbooking.back.management.categories.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CreateCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void handle(Category category) throws BadRequestException {
        log.info("Executing CreateCategoryService.handle()");
        categoryRepository.save(category);
        log.info("Category created with id: {} and name: {}", category.getId(), category.getTitle());
    }

}
