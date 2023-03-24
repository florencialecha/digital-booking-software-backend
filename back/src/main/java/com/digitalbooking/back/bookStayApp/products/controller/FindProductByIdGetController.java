package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.products.service.FindProductByIdService;
import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import com.digitalbooking.back.bookStayApp.address.Address;
import com.digitalbooking.back.bookStayApp.address.AddressToFindDTO;
import com.digitalbooking.back.bookStayApp.reserves.Reserve;
import com.digitalbooking.back.bookStayApp.reserves.ReserveToFindDTO;
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

        log.info("Find product by id: " + id);
        Optional<Product> productOptional = findProductByIdService.findById(id);
        Product product = productOptional.orElseThrow(() ->
                new ResourceNotFoundException("Don't find any product with id: " + id + ". Try again.")
        );
        log.info("Product found: " + product.getId());

        ProductWithDetailsToFindDTO productWithDetailsToFindDTO = modelMapper.map(product, ProductWithDetailsToFindDTO.class);

        //Obtener objeto de categoría del objeto de productos
        String categoryName = product.getCategory().getTitle();
        productWithDetailsToFindDTO.setCategory(categoryName);

        //Obtener objeto dirección del objeto de productos
        Address address = product.getAddress();
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

        // Obtener las reservas correspondientes al producto
        Set<Reserve> reserves = product.getReserves();
        Set<ReserveToFindDTO> reserveToFindDTOs = new HashSet<>();
        for (Reserve reserve : reserves) {
            ReserveToFindDTO reserveToFindDTO = modelMapper.map(reserve, ReserveToFindDTO.class);
            reserveToFindDTOs.add(reserveToFindDTO);
        }
        productWithDetailsToFindDTO.setReserve(reserveToFindDTOs);

        return ResponseEntity.status(200).body(productWithDetailsToFindDTO);
    }

}
