package com.digitalbooking.back.management.locations.service;

import com.digitalbooking.back.bookStayApp.products.exception.BadRequestException;
import com.digitalbooking.back.management.locations.domain.Country;
import com.digitalbooking.back.management.locations.domain.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCountryService {

    @Autowired
    private CountryRepository countryRepository;

    public void handle(Country country) throws BadRequestException {
        countryRepository.save(country);
    }
}
