package com.digitalbooking.back.bookStay.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class FindByIdAddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Optional<Address> handle(Long id) throws NotFoundException {
        return addressRepository.findById(id);
    }

}
