package com.digitalbooking.back.bookStayApp.products.service;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.digitalbooking.back.bookStayApp.products.domain.ProductRepository;
import com.digitalbooking.back.bookStayApp.reserves.domain.Reserve;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@Log4j2
public class FindProductsByCityAndDatesService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> handle(String cityName, String checkIn, String checkOut) {

        log.info("Executing FindProductByCityAndDatesService.handle()");
        List<Product> products = productRepository.findByAddressCityName(cityName);
        LocalDate checkInDate = LocalDate.parse(checkIn);
        LocalDate checkOutDate = LocalDate.parse(checkOut);
        products.removeIf(product -> !isProductAvailable(product, checkInDate, checkOutDate));
        log.info("Found {} products", products.size());
        return products;
    }

    private boolean isProductAvailable(Product product, LocalDate checkIn, LocalDate checkOut) {
        log.info("Executing FindProductByCityAndDatesService.isProductAvailable()");
        Set<Reserve> reserves = product.getReserves();
        for (Reserve reserve : reserves) {
            LocalDate reserveCheckIn = reserve.getCheckIn();
            LocalDate reserveCheckOut = reserve.getCheckOut();
            if (reserveCheckIn.isBefore(checkOut) && reserveCheckOut.isAfter(checkIn)) {
                return false;
            }
        }
        return true;
    }

}
