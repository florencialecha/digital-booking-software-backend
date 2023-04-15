package com.digitalbooking.back.management.features.controller;

import com.digitalbooking.back.management.features.domain.Feature;
import com.digitalbooking.back.management.features.dto.FeatureToFindDTO;
import com.digitalbooking.back.management.features.service.FindAllFeatureService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/feature")
@CrossOrigin("*")
@Log4j2
public class FindAllFeaturesGetController {

    @Autowired
    private FindAllFeatureService findAllFeatureService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<FeatureToFindDTO>> handle() {
        log.info("Request received on FindAllFeatureGetController");

        // Retrieve all features using the findAllFeatureService
        List<Feature> features = findAllFeatureService.handle();

        if (features.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Map the features to FeatureToFindDTO using the modelMapper object
        List<FeatureToFindDTO> featureToFindDTOS = features.stream()
                .map(feature -> {
                    // Map the feature entity to FeatureToFindDTO
                    FeatureToFindDTO featureToFindDTO = modelMapper.map(feature, FeatureToFindDTO.class);

                    // Return the features as a list of FeatureToFindDTO
                    return featureToFindDTO;
                })
                .collect(Collectors.toList());

        log.info("Response sent from FindAllFeatureGetController");
        return ResponseEntity.ok(featureToFindDTOS);
    }
}
