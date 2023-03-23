package com.digitalbooking.back.management.features;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private void handle(@RequestBody FeatureDTO featureDTO) {
        try {
            Feature feature = modelMapper.map(featureDTO, Feature.class);
            createFeatureService.handle(feature);
        } catch (Exception e) {
            log.error("Error al crear feature", e);
        }
    }
}
