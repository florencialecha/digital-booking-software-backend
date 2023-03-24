package com.digitalbooking.back.bookStayApp.reserves;

import com.digitalbooking.back.bookStayApp.products.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateReserveService {
    @Autowired
    private ReserveRepository reserveRepository;

    public void handle(Reserve reserve) throws BadRequestException {
        reserveRepository.save(reserve);
    }
}
