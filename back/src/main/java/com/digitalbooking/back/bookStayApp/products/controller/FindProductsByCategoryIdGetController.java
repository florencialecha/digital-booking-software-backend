//package com.digitalbooking.back.bookStayApp.products.controller;
//
//import com.digitalbooking.back.bookStayApp.address.AddressToFindDTO;
//import com.digitalbooking.back.bookStayApp.products.service.FindProductsByCategoryIdService;
//import com.digitalbooking.back.bookStayApp.products.domain.Product;
//import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
//import lombok.extern.log4j.Log4j2;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/product")
//@CrossOrigin("*")
//@Log4j2
//public class FindProductsByCategoryIdGetController {
//
//    @Autowired
//    private FindProductsByCategoryIdService findProductsByCategoryIdService;
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @GetMapping("/byCategory/{categoryId}")
//    public ResponseEntity<List<ProductToFindDTO>> handle(@PathVariable Long categoryId) throws ResourceNotFoundException {
//        List<Product> products = findProductsByCategoryIdService.handle(categoryId);
//        if (products.isEmpty()) {
//            throw new ResourceNotFoundException("Can't find a products on this category.");
//        }
//
//        List<ProductToFindDTO> productDTOS = products.stream()
//                .map(product -> {
//                    ProductToFindDTO productToFindDto = modelMapper.map(product, ProductToFindDTO.class);
//                    AddressToFindDTO addressToFindDTO = modelMapper.map(product.getAddress(), AddressToFindDTO.class);
//                    String city = product.getAddress().getCity().getName();
//                    String state = product.getAddress().getCity().getState().getName();
//                    String country = product.getAddress().getCity().getState().getCountry().getName();
//                    addressToFindDTO.setCity(city);
//                    addressToFindDTO.setState(state);
//                    addressToFindDTO.setCountry(country);
//                    productToFindDto.setAddress(addressToFindDTO);
//                    return productToFindDto;
//                })
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(productDTOS);
//    }
//}
