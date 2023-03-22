package com.digitalbooking.back.bookStayApp.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AddressDTOToCreate {

    private String street;
    private String number;
    private Long city;

}
