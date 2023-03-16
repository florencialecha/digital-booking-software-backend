package com.digitalbooking.back.management.categories.controller;

import com.digitalbooking.back.management.categories.entity.Category;
import com.digitalbooking.back.management.categories.service.FindAllCategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
@Log4j2

public class FindAllCategoryGetController {

    @Autowired
    private FindAllCategoryService findAllCategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> handle() {
        try {
            List<Category> categories = findAllCategoryService.handle();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error while finding all categories: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
