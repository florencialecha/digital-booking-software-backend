package com.digitalbooking.back.management.locations.service;

import com.digitalbooking.back.bookStayApp.products.exception.BadRequestException;
import com.digitalbooking.back.management.locations.domain.Country;
import com.digitalbooking.back.management.locations.domain.CountryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CreateCountryService {

    @Autowired
    private CountryRepository countryRepository;

    public void handle(Country country) throws BadRequestException {
        log.info("Executing CreateCountryService.handle()");
        countryRepository.save(country);
        log.info("Country created with id: {} and name: {}", country.getId(), country.getName());
    }
}
