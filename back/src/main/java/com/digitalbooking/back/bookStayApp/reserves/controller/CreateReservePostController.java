package com.digitalbooking.back.bookStayApp.reserves.controller;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.domain.ProductRepository;
import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import com.digitalbooking.back.bookStayApp.reserves.service.CreateReserveService;
import com.digitalbooking.back.bookStayApp.reserves.domain.Reserve;
import com.digitalbooking.back.bookStayApp.reserves.dto.ReserveToCreateDTO;
import com.digitalbooking.back.management.security.users.User;
import com.digitalbooking.back.management.security.users.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/reserve")
@CrossOrigin("*")
@Log4j2
public class CreateReservePostController {

    @Autowired
    private CreateReserveService createReserveService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public void handle(@RequestBody ReserveToCreateDTO reserveToCreateDTO) {
        log.info("Request received on CreateReservePostController");

        try {
            // Map the DTO to the Reserve entity
            Reserve reserve = modelMapper.map(reserveToCreateDTO, Reserve.class);

            // Assign the product to the reserve using the product ID
            Product product = productRepository.findById(reserveToCreateDTO.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            reserve.setProduct(product);

            // Assign the user to the reserve using the user ID
            User user = userRepository.findById(reserveToCreateDTO.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));
            reserve.setUser(user);

            // Create the reserve using the createReserveService
            createReserveService.handle(reserve);
            log.info("Response sent from CreateReservePostController");

        } catch (ResourceNotFoundException e) {
            log.error("Can't create a reserve, product or user don't found: " + e.getMessage());

        } catch (Exception e) {
            log.error("Can't create a reserve: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating reserve", e);
        }
    }
}
