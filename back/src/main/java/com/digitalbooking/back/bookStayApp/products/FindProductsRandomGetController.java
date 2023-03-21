package com.digitalbooking.back.bookStayApp.products;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class FindProductsRandomGetController {

     @Autowired
     private FindProductsRandomService findProductsRandomService;

     @GetMapping("/random")
     public ResponseEntity<List<Product>> handle() {
        List<Product> allProducts = findProductsRandomService.handle();
        Collections.shuffle(allProducts);
        List<Product> randomProducts = allProducts.subList(0, 8);
        return ResponseEntity.status(200).body(randomProducts);
     }

}
