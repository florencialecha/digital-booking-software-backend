package com.digitalbooking.back.bookStayApp.reserves;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.domain.ProductRepository;
//import com.digitalbooking.back.management.users.User;
//import com.digitalbooking.back.management.users.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserve")
@CrossOrigin("*")
@Log4j2
public class CreateReservePostController {

    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CreateReserveService createReserveService;
    @Autowired
    private ProductRepository productRepository;
//    @Autowired
//    private UserRepository userRepository;

    @PostMapping
    public void handle(@RequestBody ReserveToCreateDTO reserveToCreateDTO) {
        try {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Reserve reserve = modelMapper.map(reserveToCreateDTO, Reserve.class);

            // Asignar producto por id
            Product product = productRepository.findById(reserveToCreateDTO.getProduct())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            reserve.setProduct(product);

//            // Asignar usuario por id
//            User user = userRepository.findById(reserveToCreateDTO.getUser())
//                    .orElseThrow(() -> new RuntimeException("User not found"));
//            reserve.setUser(user);

            createReserveService.handle(reserve);
            log.info("Reserve created successfully with id: " + reserve.getId());
        } catch (Exception e) {
            log.error("Can't create a reserve: ", e);
        }
    }
}
