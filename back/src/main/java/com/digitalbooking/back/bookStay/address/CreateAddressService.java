package com.digitalbooking.back.bookStay.address;

import com.digitalbooking.back.management.categories.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void handle(Address address) throws BadRequestException {
        addressRepository.save(address);
    }

}
