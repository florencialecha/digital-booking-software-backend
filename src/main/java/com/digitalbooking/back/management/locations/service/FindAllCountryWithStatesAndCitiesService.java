package com.digitalbooking.back.management.locations.service;

import com.digitalbooking.back.management.locations.domain.Country;
import com.digitalbooking.back.management.locations.domain.CountryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class FindAllCountryWithStatesAndCitiesService {
    @Autowired
    private CountryRepository countryRepository;
    public List<Country> handle() {
        log.info("Executing FindAllCountryWithStatesAndCitiesService.handle()");
        List<Country> countries = countryRepository.findAll();
        log.info("Found {} countries", countries.size());
        return countries;
    }

}
