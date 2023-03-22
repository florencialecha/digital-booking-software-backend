package com.digitalbooking.back.management.locations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CountryToCreateDTO {
    private String name;
    private Set<StateToCreateCountryDTO> states;
}
