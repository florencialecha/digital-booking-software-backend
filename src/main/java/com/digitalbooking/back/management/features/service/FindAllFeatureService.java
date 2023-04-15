package com.digitalbooking.back.management.features.service;

import com.digitalbooking.back.management.features.domain.Feature;
import com.digitalbooking.back.management.features.domain.FeatureRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class FindAllFeatureService {

    @Autowired
    private FeatureRepository featureRepository;
    public List<Feature> handle() {
        log.info("Executing FindAllFeatureService.handle()");
        List<Feature> features = featureRepository.findAll();
        log.info("Found {} features", features.size());
        return features;
    }
}
