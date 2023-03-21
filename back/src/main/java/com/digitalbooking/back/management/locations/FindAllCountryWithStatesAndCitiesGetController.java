package com.digitalbooking.back.management.locations;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
@Log4j2

public class FindAllCountryWithStatesAndCitiesGetController {

     @Autowired
     private FindAllCountryWithStatesAndCitiesService findAllCountryWithStatesAndCitiesService;

     @GetMapping
     public ResponseEntity<List<Country>> handle() {
         List<Country> countries = findAllCountryWithStatesAndCitiesService.handle();
         return ResponseEntity.ok(countries);
     }

}
