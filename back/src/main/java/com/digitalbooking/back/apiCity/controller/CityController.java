package com.digitalbooking.back.apiCity.controller;

import com.digitalbooking.back.apiCategory.entity.Category;
import com.digitalbooking.back.apiCategory.exception.BadRequestException;
import com.digitalbooking.back.apiCategory.exception.ResourceNotFoundException;
import com.digitalbooking.back.apiCity.entity.City;
import com.digitalbooking.back.apiCity.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")

public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> findAll() {
        return cityService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<City>> findById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<City> city = cityService.findById(id);
        if (city.isEmpty()) {
            throw new ResourceNotFoundException("Don't find any city with id: " + id + ". Try again.");
        }
        return ResponseEntity.status(200).body(city);
    }

    @PostMapping
    public void create(@RequestBody City city) throws BadRequestException {
        cityService.create(city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<City> result = cityService.findById(id);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Can't delete a city who does not exist in the database.");
        }
        cityService.delete(id);
    }
}
