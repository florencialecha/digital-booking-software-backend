package com.digitalbooking.back.management.locations.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CountryToFindDTO {
    private Long id;
    private String name;
    private Set<StateToFindCountryDTO> states;
}
