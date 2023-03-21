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

public class FindProductByCityAndDatesGetController {

    @Autowired
    private FindProductByCityAndDatesService findProductByCityAndDatesService;

    @GetMapping("/byCityAndDates/{cityName}/{checkIn}/{checkOut}")
    public ResponseEntity<List<Product>> handle(
            @PathVariable String cityName,
            @PathVariable String checkIn,
            @PathVariable String checkOut) throws ResourceNotFoundException {
        List<Product> products = findProductByCityAndDatesService.handle(cityName, checkIn, checkOut);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a products available on this city for this dates.");
        }
        return ResponseEntity.ok(products);
    }
}
