package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.products.dto.ProductWithDetailsToFindDTO;
import com.digitalbooking.back.bookStayApp.products.service.FindProductByIdService;
import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import com.digitalbooking.back.bookStayApp.address.domain.Address;
import com.digitalbooking.back.bookStayApp.address.dto.AddressToFindDTO;
import com.digitalbooking.back.bookStayApp.reserves.domain.Reserve;
import com.digitalbooking.back.bookStayApp.reserves.dto.ReserveToFindDTO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2
public class FindProductByIdGetController {

    @Autowired
    private FindProductByIdService findProductByIdService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("{id}")
    public ResponseEntity<ProductWithDetailsToFindDTO> findById(@PathVariable Long id) throws ResourceNotFoundException {
        log.info("Request received on FindProductByIdGetController with id {} ", id);

        Optional<Product> productOptional = findProductByIdService.handle(id);

        // If the product is not found, throw an exception
        Product product = productOptional.orElseThrow(() ->
                new ResourceNotFoundException("Don't find any product with id: " + id + ". Try again.")
        );

        log.info("Product found: " + product.getId());
        // Map the product (domain object) to ProductWithDetailsToFindDTO
        ProductWithDetailsToFindDTO productWithDetailsToFindDTO = modelMapper.map(product, ProductWithDetailsToFindDTO.class);

        // Get the category name object from the product object and set it in the dto
        String categoryName = product.getCategory().getTitle();
        productWithDetailsToFindDTO.setCategory(categoryName);

        // Get the address object from the product object and map it to an AddressToFindDTO object
        Address address = product.getAddress();
        AddressToFindDTO addressToFindDTO = modelMapper.map(address, AddressToFindDTO.class);

        // Set the city, state, and country values from the address object to the AddressToFindDTO object
        String cityName = address.getCity().getName();
        String stateName = address.getCity().getState().getName();
        String countryName = address.getCity().getState().getCountry().getName();
        addressToFindDTO.setCity(cityName);
        addressToFindDTO.setState(stateName);
        addressToFindDTO.setCountry(countryName);
        productWithDetailsToFindDTO.setAddress(addressToFindDTO);

        // Get the reserves corresponding to the product and map them to ReserveToFindDTO objects
        Set<Reserve> reserves = product.getReserves();
        Set<ReserveToFindDTO> reserveToFindDTOs = new HashSet<>();
        for (Reserve reserve : reserves) {
            ReserveToFindDTO reserveToFindDTO = modelMapper.map(reserve, ReserveToFindDTO.class);
            reserveToFindDTOs.add(reserveToFindDTO);
        }
        productWithDetailsToFindDTO.setReserve(reserveToFindDTOs);

        log.info("Response sent from FindProductsByIdGetController");
        return ResponseEntity.status(200).body(productWithDetailsToFindDTO);
    }
}
