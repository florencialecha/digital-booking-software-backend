package com.digitalbooking.back.category.service;

import com.digitalbooking.back.category.exception.BadRequestException;
import com.digitalbooking.back.category.entity.Category;
import com.digitalbooking.back.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<List<Category>> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public void create(Category category) throws BadRequestException {
        categoryRepository.save(category);
    }

    public void update(Category category) {
        categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

}
