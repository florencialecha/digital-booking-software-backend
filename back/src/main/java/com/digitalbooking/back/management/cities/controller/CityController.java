package com.digitalbooking.back.management.cities.controller;

import com.digitalbooking.back.management.categories.exception.BadRequestException;
import com.digitalbooking.back.management.categories.exception.ResourceNotFoundException;
import com.digitalbooking.back.management.cities.entity.City;
import com.digitalbooking.back.management.cities.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
@CrossOrigin("*")

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
