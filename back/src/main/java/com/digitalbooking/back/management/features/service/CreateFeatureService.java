package com.digitalbooking.back.management.features.service;

import com.digitalbooking.back.bookStayApp.products.exception.BadRequestException;
import com.digitalbooking.back.management.features.domain.Feature;
import com.digitalbooking.back.management.features.domain.FeatureRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CreateFeatureService {
    @Autowired
    private FeatureRepository featureRepository;
    public void handle(Feature feature) throws BadRequestException {
        log.info("Executing CreateFeatureService.handle()");
        featureRepository.save(feature);
        log.info("Feature created with id: {}", feature.getId());
    }
}
