package com.digitalbooking.back.bookStayApp.address.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class AddressToCreateDTO {
    private String street;
    private String number;
    private Long city;
}
