package com.digitalbooking.back.bookStayApp.products.controller;

import com.digitalbooking.back.bookStayApp.address.dto.AddressToFindDTO;
import com.digitalbooking.back.bookStayApp.products.dto.ProductToFindDTO;
import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import com.digitalbooking.back.bookStayApp.products.service.FindAllProductsService;
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

public class FindAllProductsGetController {

    @Autowired
    private FindAllProductsService findAllProductsService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProductToFindDTO>> handle() throws ResourceNotFoundException {
        log.info("Request received on FindAllProductsGetController");

        // Retrieve all products using the findAllProductService
        List<Product> products = findAllProductsService.handle();

        // TODO: Esta excepción es correcto manejarlo así? debería se una excep. o sólo un aviso?
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a products availables.");
        }

        // Map the products to ProductToFindDTO using the modelMapper object
        List<ProductToFindDTO> productsToFindDTOS = products.stream()
                .map(product -> {
                    // Map the product (domain object) to ProductToFindDTO
                    ProductToFindDTO productToFindDto = modelMapper.map(product, ProductToFindDTO.class);

                    // Get the category name and set it in the DTO
                    String categoryName = product.getCategory().getTitle();
                    productToFindDto.setCategory(categoryName);

                    // Map the address to AddressToFindDTO and set the city, state and country names in the DTO
                    AddressToFindDTO addressToFindDTO = modelMapper.map(product.getAddress(), AddressToFindDTO.class);
                    String cityName = product.getAddress().getCity().getName();
                    String stateName = product.getAddress().getCity().getState().getName();
                    String countryName = product.getAddress().getCity().getState().getCountry().getName();
                    addressToFindDTO.setCity(cityName);
                    addressToFindDTO.setState(stateName);
                    addressToFindDTO.setCountry(countryName);
                    productToFindDto.setAddress(addressToFindDTO);

                    // Return the products as a list of ProductToFindDTO
                    return productToFindDto;
                })
                .collect(Collectors.toList());

        log.info("Response sent from FindAllProductsGetController");
        return ResponseEntity.ok(productsToFindDTOS);
    }

}
