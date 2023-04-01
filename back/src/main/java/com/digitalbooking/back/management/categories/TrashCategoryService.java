//package com.digitalbooking.back.management.categories.service;
//
//import com.digitalbooking.back.management.categories.exception.BadRequestException;
//import com.digitalbooking.back.management.categories.domain.Category;
//import com.digitalbooking.back.management.categories.domain.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CategoryService {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    public List<Category> findAll() {
//        return categoryRepository.findAll();
//    }
//
//    public void create(Category category) throws BadRequestException {
//        categoryRepository.save(category);
//    }
//
//// SI NO SE USA ELIMINAR
////    public Optional<Category> findById(Long id) {
////        return categoryRepository.findById(id);
////    }
////
////    public Optional<List<Category>> findByTitle(String title) {
////        return categoryRepository.findByTitle(title);
////    }
////
////    public void update(Category category) {
////        categoryRepository.save(category);
////    }
////
////    public void delete(Long id) {
////        categoryRepository.deleteById(id);
////    }
//
//}
