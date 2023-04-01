package com.digitalbooking.back.management.locations.controller;

import com.digitalbooking.back.management.locations.domain.Country;
import com.digitalbooking.back.management.locations.service.FindAllCountryWithStatesAndCitiesService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
     @Autowired
     private ModelMapper modelMapper;

     @GetMapping
     public ResponseEntity<List<Country>> handle() {
         List<Country> countries = findAllCountryWithStatesAndCitiesService.handle();
         return ResponseEntity.ok(countries);
     }

}
