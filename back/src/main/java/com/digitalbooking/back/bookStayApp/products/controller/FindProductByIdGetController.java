package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.address.Address;
import com.digitalbooking.back.bookStayApp.address.AddressToFindDTO;
import com.digitalbooking.back.bookStayApp.products.service.FindProductByIdService;
import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import com.digitalbooking.back.bookStayApp.reserves.Reserve;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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

        log.info("Find product by id: " + id);
        Optional<Product> product = findProductByIdService.findById(id);
        log.info("Product found: " + product);

        if (product.isEmpty()) {
            throw new ResourceNotFoundException("Don't find any product with id: " + id + ". Try again.");
        }

        ProductWithDetailsToFindDTO productWithDetailsToFindDTO = modelMapper.map(product, ProductWithDetailsToFindDTO.class);

        //Obtener objeto dirección del objeto de productos
        Address address = product.get().getAddress();
        //Mapear dirección a direcciónDTO  y establecer los valores de ciudad, estado y país a partir del objeto de dirección obtenido
        AddressToFindDTO addressToFindDTO = modelMapper.map(address, AddressToFindDTO.class);
        String cityName = address.getCity().getName();
        String stateName = address.getCity().getState().getName();
        String countryName = address.getCity().getState().getCountry().getName();
        addressToFindDTO.setCity(cityName);
        addressToFindDTO.setState(stateName);
        addressToFindDTO.setCountry(countryName);

        //Establecer direcciónDTO en el objeto de productosDTO
        productWithDetailsToFindDTO.setAddress(addressToFindDTO);

        return ResponseEntity.status(200).body(productWithDetailsToFindDTO);
    }

}
