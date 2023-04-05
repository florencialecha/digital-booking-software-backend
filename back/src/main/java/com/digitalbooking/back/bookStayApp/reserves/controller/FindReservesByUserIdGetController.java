package com.digitalbooking.back.bookStayApp.reserves.controller;

import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import com.digitalbooking.back.bookStayApp.reserves.domain.Reserve;
import com.digitalbooking.back.bookStayApp.reserves.dto.ReservesUserDTO;
import com.digitalbooking.back.bookStayApp.reserves.service.FindReservesByUserIdService;
import com.digitalbooking.back.management.security.users.User;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reserve")
@CrossOrigin("*")
@Log4j2
public class FindReservesByUserIdGetController {

    @Autowired
    private FindReservesByUserIdService findReservesByUserIdService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/byUserId")
    public ResponseEntity<List<ReservesUserDTO>> handle(@AuthenticationPrincipal User user) throws ResourceNotFoundException {
        log.info("Request received on FindReservesByUserIdGetController");
        log.info("Received User id: {} by JWT", user.getId());
        // Retrieve all reserves by user id using the findReservesByUserIdService
        List<Reserve> reserves = findReservesByUserIdService.handle(user.getId());

        if (reserves.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a reserves on this user.");
        }

        // Map the reserves to ReservesUserDTO using the modelMapper object
        List<ReservesUserDTO> reservesDTOS = reserves.stream()
                .map(reserve -> {
                    // Map the reserve entity to DTO
                    ReservesUserDTO reservesUserDTO = modelMapper.map(reserve, ReservesUserDTO.class);
                    //Set the reserve id
                    reservesUserDTO.setIdReserve(reserve.getId());
                    // Set the product name
                    String productName = reserve.getProduct().getTitle();
                    reservesUserDTO.setProductName(productName);
                    // Return the reserves as a list of ReservesUserDTO
                    return reservesUserDTO;
                })
                .collect(Collectors.toList());

        log.info("Response sent from FindReservesByUserIdGetController");
        return ResponseEntity.ok(reservesDTOS);
    }


}
