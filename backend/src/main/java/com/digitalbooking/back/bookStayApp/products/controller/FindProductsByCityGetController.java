package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.address.dto.AddressToFindDTO;
import com.digitalbooking.back.bookStayApp.products.dto.ProductToFindDTO;
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
    public ResponseEntity<List<ProductToFindDTO>> handle(
            @PathVariable String cityName) throws ResourceNotFoundException {
        log.info("Request received on FindProductsByCityGetController with cityName: {} ", cityName);

        // Retrieve all products using the findAllProductService
        List<Product> products = findProductsByCityService.handle(cityName);

        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a products on this city.");
        }

        // Map the products to ProductToFindDTO using the modelMapper object
        List<ProductToFindDTO> productDTOS = products.stream()
                .map(product -> {
                    // Map the product (domain object) to ProductToFindDTO
                    ProductToFindDTO productToFindDto = modelMapper.map(product, ProductToFindDTO.class);

                    // Get the category name and set it in the DTO
                    String categoryName = product.getCategory().getTitle();
                    productToFindDto.setCategory(categoryName);

                    //  Map the address to AddressToFindDTO and set the city, state and country names in the DTO
                    AddressToFindDTO addressToFindDTO = modelMapper.map(product.getAddress(), AddressToFindDTO.class);
                    String city = product.getAddress().getCity().getName();
                    String state = product.getAddress().getCity().getState().getName();
                    String country = product.getAddress().getCity().getState().getCountry().getName();
                    addressToFindDTO.setCity(city);
                    addressToFindDTO.setState(state);
                    addressToFindDTO.setCountry(country);
                    productToFindDto.setAddress(addressToFindDTO);

                    // Return the products as a list of ProductToFindDTO
                    return productToFindDto;
                })
                .collect(Collectors.toList());

        log.info("Response sent from FindProductsByCityGetController");
        return ResponseEntity.ok(productDTOS);
    }

}
