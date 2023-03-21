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
public class StateDTO {

    private String name;
    private Set<CityDTO> cities;
}
