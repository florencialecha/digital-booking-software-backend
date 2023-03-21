package com.digitalbooking.back.management.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCountryWithStatesAndCitiesService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> handle() {
        return countryRepository.findAll();
    }

}
