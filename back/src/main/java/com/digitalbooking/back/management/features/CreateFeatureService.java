package com.digitalbooking.back.management.features;

import com.digitalbooking.back.bookStayApp.products.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateFeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public void handle(Feature feature) throws BadRequestException {
        featureRepository.save(feature);
    }
}
