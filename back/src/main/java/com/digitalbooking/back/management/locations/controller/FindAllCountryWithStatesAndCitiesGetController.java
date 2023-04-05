package com.digitalbooking.back.management.locations.controller;

import com.digitalbooking.back.management.locations.domain.Country;
import com.digitalbooking.back.management.locations.domain.State;
import com.digitalbooking.back.management.locations.dto.CountryToFindDTO;
import com.digitalbooking.back.management.locations.dto.StateToFindCountryDTO;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
@Log4j2
public class FindAllCountryWithStatesAndCitiesGetController {

    //TODO: La mejor práctica sería inyectar las dependencias vía constructor, investigar
     @Autowired
     private FindAllCountryWithStatesAndCitiesService findAllCountryWithStatesAndCitiesService;
     @Autowired
     private ModelMapper modelMapper;

     @GetMapping
     public ResponseEntity<List<CountryToFindDTO>> handle() {
         log.info("Request received on FindAllCountryWithStatesAndCitiesGetController");

         // Retrieve all countries using the findAllCountryWithStatesAndCitiesService
         List<Country> countries = findAllCountryWithStatesAndCitiesService.handle();

         //If there are no countries, return a 404
         if (countries.isEmpty()) {
             return ResponseEntity.notFound().build();
         }

         // Map the countries to CountryToFindDTO using the modelMapper object
         List<CountryToFindDTO> countryToFindDTOS = countries.stream()
                 .map(country -> modelMapper.map(country, CountryToFindDTO.class))
                 .collect(Collectors.toList());

         log.info("Response sent from FindAllCountryWithStatesAndCitiesGetController");
         return ResponseEntity.ok(countryToFindDTOS);
    }
}
