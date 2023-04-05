package com.digitalbooking.back.bookStayApp.reserves.controller;

import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
import com.digitalbooking.back.bookStayApp.reserves.dto.ReserveToFindDTO;
import com.digitalbooking.back.bookStayApp.reserves.service.FindReservesByProductIdService;
import com.digitalbooking.back.bookStayApp.reserves.domain.Reserve;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reserve")
@CrossOrigin("*")
@Log4j2
public class FindReservesByProductIdGetController {

    @Autowired
    private FindReservesByProductIdService findReservesByProductIdService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/byProductId/{idProduct}")
    public ResponseEntity<List<ReserveToFindDTO>> handle(@PathVariable Long idProduct) throws ResourceNotFoundException {
        log.info("Request received on FindReservesByProductIdGetController");

        // Retrieve all reserves by product id using the findReservesByProductIdService
        List<Reserve> reserves = findReservesByProductIdService.handle(idProduct);

        if (reserves.isEmpty()) {
            throw new ResourceNotFoundException("Can't find a reserves for this product.");
        }

        // Map the reserves to ReserveToFindDTO using the modelMapper object
        List<ReserveToFindDTO> reserveDTOS = reserves.stream()
                .map(reserve -> {
                    // Map the reserve entity to DTO
                    ReserveToFindDTO reserveToFindDTO = modelMapper.map(reserve, ReserveToFindDTO.class);

                    // Return the reserves as a list of ReserveToFindDTO
                    return reserveToFindDTO;
                })
                .collect(Collectors.toList());

        log.info("Response sent from FindReservesByProductIdGetController");
        return ResponseEntity.ok(reserveDTOS);
    }

}
