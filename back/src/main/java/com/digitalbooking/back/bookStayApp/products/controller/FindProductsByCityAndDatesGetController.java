package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.address.AddressToFindDTO;
import com.digitalbooking.back.bookStayApp.products.service.FindProductByCityAndDatesService;
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

public class FindProductsByCityAndDatesGetController {

    @Autowired
    private FindProductByCityAndDatesService findProductByCityAndDatesService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/byCityAndDates/{cityName}/{checkIn}/{checkOut}")
    public ResponseEntity<List<ProductToFindDTO>> handle(
            @PathVariable String cityName,
            @PathVariable String checkIn,
            @PathVariable String checkOut) throws ResourceNotFoundException {

        List<Product> products = findProductByCityAndDatesService.handle(cityName, checkIn, checkOut);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a products available on this city for this dates.");
        }

        List<ProductToFindDTO> productDTOS = products.stream()
                .map(product -> {
                    ProductToFindDTO productToFindDto = modelMapper.map(product, ProductToFindDTO.class);
                    String categoryName = product.getCategory().getTitle();
                    productToFindDto.setCategory(categoryName);
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