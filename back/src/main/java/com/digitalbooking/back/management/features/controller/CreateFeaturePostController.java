package com.digitalbooking.back.management.features.controller;

import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import com.digitalbooking.back.management.features.dto.FeatureToCreateDTO;
import com.digitalbooking.back.management.features.service.CreateFeatureService;
import com.digitalbooking.back.management.features.domain.Feature;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/feature")
@CrossOrigin("*")
@Log4j2
public class CreateFeaturePostController {
    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CreateFeatureService createFeatureService;

    @PostMapping
    private void handle(@RequestBody FeatureToCreateDTO featureToCreateDTO) throws ResourceNotFoundException {
        log.info("Request received on CreateFeaturePostController");

        try {
            //Map DTO to Feature entity with ModelMapper
            Feature feature = modelMapper.map(featureToCreateDTO, Feature.class);

            //Create the feature using the createFeatureService
            createFeatureService.handle(feature);
            log.info("Response sent from CreateFeaturePostController");

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating feature", e);
        }
    }
}
