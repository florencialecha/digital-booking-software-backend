package com.digitalbooking.back.bookStay.products;

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
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class FindAllProductGetController {

    @Autowired
    private FindAllProductService findAllProductService;

    @GetMapping
    public ResponseEntity<List<Product>> handle() {
        try {
            List<Product> products = findAllProductService.handle();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error while finding all products: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
