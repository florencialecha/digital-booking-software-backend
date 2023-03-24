package com.digitalbooking.back.bookStayApp.products.controller;

//import com.digitalbooking.back.bookStayApp.address.AddressToFindDTO;
import com.digitalbooking.back.bookStayApp.products.service.FindAllProductService;
import com.digitalbooking.back.bookStayApp.products.domain.Product;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class FindAllProductGetController {

    @Autowired
    private FindAllProductService findAllProductService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProductToFindDTO>> handle() {
        List<Product> products = findAllProductService.handle();

        List<ProductToFindDTO> productsToFindDTOS= products.stream()
                .map(product -> {
                    ProductToFindDTO productToFindDto = modelMapper.map(product, ProductToFindDTO.class);
                    String categoryName = product.getCategory().getTitle();
                    productToFindDto.setCategory(categoryName);
                    //                    AddressToFindDTO addressToFindDTO = modelMapper.map(product.getAddress(), AddressToFindDTO.class);
//                    String cityName = product.getAddress().getCity().getName();
//                    String stateName = product.getAddress().getCity().getState().getName();
//                    String countryName = product.getAddress().getCity().getState().getCountry().getName();
//                    addressToFindDTO.setCity(cityName);
//                    addressToFindDTO.setState(stateName);
//                    addressToFindDTO.setCountry(countryName);
//                    productToFindDto.setAddress(addressToFindDTO);
                    return productToFindDto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(productsToFindDTOS);
    }
}
