package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.address.AddressToFindDTO;
import com.digitalbooking.back.bookStayApp.products.service.FindProductsByCityService;
import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class FindProductsByCityGetController {

    @Autowired
    private FindProductsByCityService findProductsByCityService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/byCity/{cityName}")
    public ResponseEntity<List<ProductToFindDTO>> handle(@PathVariable String cityName) throws ResourceNotFoundException {

        List<Product> products = findProductsByCityService.handle(cityName);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a products on this city.");
        }

        List<ProductToFindDTO> productDTOS = products.stream()
                .map(product -> {
                    ProductToFindDTO productToFindDto = modelMapper.map(product, ProductToFindDTO.class);
                    AddressToFindDTO addressToFindDTO = modelMapper.map(product.getAddress(), AddressToFindDTO.class);
                    String city = product.getAddress().getCity().getName();
                    String state = product.getAddress().getCity().getState().getName();
                    String country = product.getAddress().getCity().getState().getCountry().getName();
                    addressToFindDTO.setCity(city);
                    addressToFindDTO.setState(state);
                    addressToFindDTO.setCountry(country);
                    productToFindDto.setAddress(addressToFindDTO);
                    return productToFindDto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(productDTOS);
    }

}
