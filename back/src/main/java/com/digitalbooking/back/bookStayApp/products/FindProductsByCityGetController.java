package com.digitalbooking.back.bookStayApp.products;

import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class FindProductsByCityGetController {

    @Autowired
    private FindProductsByCityService findProductsByCityService;

    @GetMapping("/byCity/{cityName}")
    public ResponseEntity<List<Product>> handle(@PathVariable String cityName) throws ResourceNotFoundException {
        List<Product> products = findProductsByCityService.handle(cityName);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a products on this city.");
        }
        return ResponseEntity.ok(products);
    }

}
