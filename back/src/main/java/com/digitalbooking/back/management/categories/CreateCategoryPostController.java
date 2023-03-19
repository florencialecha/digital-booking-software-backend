package com.digitalbooking.back.management.categories;

import com.digitalbooking.back.management.categories.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
@Log4j2

public class CreateCategoryPostController {

    @Autowired
    private CreateCategoryService createCategoryService;

    @PostMapping
    public void handle(@RequestBody Category category) {
        try {
            createCategoryService.handle(category);
            log.info("Category created successfully");
        } catch (BadRequestException e) {
            log.error("Bad Request Exception: {}", e.getMessage());
        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
        }
    }
}
