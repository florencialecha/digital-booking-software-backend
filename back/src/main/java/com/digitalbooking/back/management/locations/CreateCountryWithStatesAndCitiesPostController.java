package com.digitalbooking.back.management.locations;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
@Log4j2

public class CreateCountryWithStatesAndCitiesPostController {

    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CreateCountryService createCountryService;

    @PostMapping
    public void handle(@RequestBody CountryToCreateDTO countryToCreateDTO) {

        try {
            //Create a new country with states and cities
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Country country = modelMapper.map(countryToCreateDTO, Country.class);
            //Create states
            Set<StateToCreateCountryDTO> statesDTO = countryToCreateDTO.getStates();
            if (statesDTO != null) {
                Set<State> states = new HashSet<>();
                for (StateToCreateCountryDTO stateToCreateCountryDTO : statesDTO) {
                    State state = modelMapper.map(stateToCreateCountryDTO, State.class);
                    state.setCountry(country);
                    states.add(state);

                    //Create cities
                    Set<CityToCreateCountryDTO> citiesDTO = stateToCreateCountryDTO.getCities();
                    if (citiesDTO != null) {
                        Set<City> cities = new HashSet<>();
                        for (CityToCreateCountryDTO cityToCreateCountryDTO : citiesDTO) {
                            City city = modelMapper.map(cityToCreateCountryDTO, City.class);
                            city.setState(state);
                            cities.add(city);
                        }
                        state.setCities(cities);
                    }
                }
                country.setStates(states);
            }
            createCountryService.handle(country);

        } catch (Exception e) {
            log.error("Internal Server Error: {}", e.getMessage());
        }

    }
}
