//package com.digitalbooking.back.bookStayApp.reserves;
//
//import com.digitalbooking.back.bookStayApp.products.exception.ResourceNotFoundException;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@RestController
//@RequestMapping("/reserve")
//@CrossOrigin("*")
//@Log4j2
//
//public class FindReservesByProductIdGetController {
//
//    @Autowired
//    private FindReservesByProductIdService findReservesByProductIdService;
//
//    @GetMapping("/byProductId/{idProduct}")
//    public ResponseEntity<List<Reserve>> handle(@PathVariable Long idProduct) throws ResourceNotFoundException {
//        List<Reserve> reserves = findReservesByProductIdService.handle(idProduct);
//        if (reserves.isEmpty()) {
//            throw new ResourceNotFoundException("Can't find a reserves for this product.");
//        }
//        return ResponseEntity.ok(reserves);
//    }
//
//}
