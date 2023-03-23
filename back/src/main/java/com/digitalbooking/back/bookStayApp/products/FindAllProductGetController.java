package com.digitalbooking.back.bookStayApp.products;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class FindAllProductGetController {

    @Autowired
    private FindAllProductService findAllProductService;

    @GetMapping
    public ResponseEntity<List<Product>> handle() {
        List<Product> products = findAllProductService.handle();
        return ResponseEntity.ok(products);
    }
}
