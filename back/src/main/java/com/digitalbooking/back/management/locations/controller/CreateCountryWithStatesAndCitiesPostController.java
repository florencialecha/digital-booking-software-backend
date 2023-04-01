package com.digitalbooking.back.management.locations.controller;

import com.digitalbooking.back.management.locations.domain.City;
import com.digitalbooking.back.management.locations.domain.Country;
import com.digitalbooking.back.management.locations.domain.State;
import com.digitalbooking.back.management.locations.dto.CityToCreateCountryDTO;
import com.digitalbooking.back.management.locations.dto.CountryToCreateDTO;
import com.digitalbooking.back.management.locations.dto.StateToCreateCountryDTO;
import com.digitalbooking.back.management.locations.service.CreateCountryService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
@Log4j2
public class CreateCountryWithStatesAndCitiesPostController {
    @Autowired
    private CreateCountryService createCountryService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public void handle(@RequestBody CountryToCreateDTO countryToCreateDTO) {
        log.info("Request recieved on CreateCountryWithStatesAndCitiesPostController");

        try {
            // Map DTO to Country entity with ModelMapper
            Country country = modelMapper.map(countryToCreateDTO, Country.class);

            //Create states
            Set<StateToCreateCountryDTO> statesDTO = countryToCreateDTO.getStates();
            log.info("Received {} states to save", statesDTO.size());
            Set<State> states = new HashSet<>();
            for (StateToCreateCountryDTO stateToCreateCountryDTO : statesDTO) {

                // Map DTO to State entity with ModelMapper and set country
                State state = modelMapper.map(stateToCreateCountryDTO, State.class);
                state.setCountry(country);
                states.add(state);

                //Create cities for each state
                Set<CityToCreateCountryDTO> citiesDTO = stateToCreateCountryDTO.getCities();
                log.info("Received {} cities to save", citiesDTO.size());
                Set<City> cities = new HashSet<>();
                for (CityToCreateCountryDTO cityToCreateCountryDTO : citiesDTO) {
                    // Map DTO to City entity with ModelMapper and set state
                    City city = modelMapper.map(cityToCreateCountryDTO, City.class);
                    city.setState(state);
                    cities.add(city);
                }

                // Set cities to state
                state.setCities(cities);
            }
            // Set states to country
            country.setStates(states);

            // Create the country using the createCountryService
            createCountryService.handle(country);
            log.info("Response sent from CreateCountryWithStatesAndCitiesPostController");

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating country", e);
        }

    }
}
