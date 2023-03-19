package com.digitalbooking.back.management.categories;

import com.digitalbooking.back.management.categories.exception.BadRequestException;
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
