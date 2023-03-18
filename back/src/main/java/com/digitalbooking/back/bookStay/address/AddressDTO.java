package com.digitalbooking.back.bookStay.address;

import com.digitalbooking.back.management.cities.entity.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AddressDTO {

    private String street;
    private String number;
    private City city;

}
