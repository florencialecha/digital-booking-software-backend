package com.digitalbooking.back.management.categories.service;

import com.digitalbooking.back.management.categories.domain.CategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DeleteCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void handle(Long id) {
        log.info("Executing DeleteCategoryService.handle()");
        categoryRepository.deleteById(id);
        log.info("Category deleted with id: {}", id);
    }
}
