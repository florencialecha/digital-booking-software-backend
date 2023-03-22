package com.digitalbooking.back.bookStayApp.address;

import com.digitalbooking.back.management.locations.CityDTO;
import com.digitalbooking.back.management.locations.CountryDTO;
import com.digitalbooking.back.management.locations.StateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class FindAddressDTO {

    private Long id;
    private String street;
    private String number;
    private CityDTO city;
    private StateDTO state;
    private CountryDTO country;

}
