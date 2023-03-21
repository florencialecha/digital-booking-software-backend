package com.digitalbooking.back.bookStayApp.products;

import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class FindProductByIdGetController {

    @Autowired
    private FindProductByIdService findProductByIdService;

    @GetMapping("{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) throws ResourceNotFoundException {
        log.info("Find product by id: " + id);
        Optional<Product> product = findProductByIdService.findById(id);
        log.info("Product found: " + product);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException("Don't find any product with id: " + id + ". Try again.");
        }
        return ResponseEntity.status(200).body(product);
    }

}
