package com.digitalbooking.back.management.categories.service;

import com.digitalbooking.back.management.categories.domain.Category;
import com.digitalbooking.back.management.categories.domain.CategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class FindAllCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> handle() {
        log.info("Executing FindAllCategoryService.handle()");
        List<Category> categories = categoryRepository.findAll();
        log.info("Found {} categories", categories.size());
        return categories;
    }

}
