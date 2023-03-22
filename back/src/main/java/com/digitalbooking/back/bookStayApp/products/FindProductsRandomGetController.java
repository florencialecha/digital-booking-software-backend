package com.digitalbooking.back.bookStayApp.products;

import com.digitalbooking.back.bookStayApp.address.FindAddressDTO;
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
     public ResponseEntity<List<FindProductDTO>> handle() {
        List<Product> allProducts = findProductsRandomService.handle();
        Collections.shuffle(allProducts);
        List<Product> randomProducts = allProducts.subList(0, 8);

        List<FindProductDTO> randomProductsDTOs = randomProducts.stream()
                .map(product -> {
                    FindProductDTO findProductDTO = modelMapper.map(product, FindProductDTO.class);
                    findProductDTO.setAddress(modelMapper.map(product.getAddress(), FindAddressDTO.class));
                    return findProductDTO;
                })
                .collect(Collectors.toList());
        return ResponseEntity.status(200).body(randomProductsDTOs);
     }

}
