package com.digitalbooking.back.bookStayApp.products;

import com.digitalbooking.back.bookStayApp.address.AddressDTOToCreate;
import com.digitalbooking.back.bookStayApp.address.AddressDtoToFind;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Log4j2

public class FindProductsRandomGetController {

    @Autowired
    private FindProductsRandomService findProductsRandomService;
    @Autowired
    private ModelMapper modelMapper;

     @GetMapping("/random")
     public ResponseEntity<List<ProductDtoToFind>> handle() {

        List<Product> allProducts = findProductsRandomService.handle();
        Collections.shuffle(allProducts);
        List<Product> randomProducts = allProducts.subList(0, 8);

        //randomProducts es la lista de productos(entidad) que quiero convertir a dto para devolverlos
         List<ProductDtoToFind> randomProductsDTOs = randomProducts.stream()
                 .map(product -> {
                    ProductDtoToFind productDtoToFind = modelMapper.map(product, ProductDtoToFind.class);
                     AddressDtoToFind addressDtoToFind = modelMapper.map(product.getAddress(), AddressDtoToFind.class);
                     String cityName = product.getAddress().getCity().getName();
                     String stateName = product.getAddress().getCity().getState().getName();
                     String countryName = product.getAddress().getCity().getState().getCountry().getName();
                     addressDtoToFind.setCity(cityName);
                     addressDtoToFind.setState(stateName);
                     addressDtoToFind.setCountry(countryName);
                     productDtoToFind.setAddress(addressDtoToFind);
                     return productDtoToFind;
                 })
                 .collect(Collectors.toList());

        return ResponseEntity.status(200).body(randomProductsDTOs);
     }

}
