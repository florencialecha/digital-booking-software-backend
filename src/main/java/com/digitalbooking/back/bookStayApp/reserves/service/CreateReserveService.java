package com.digitalbooking.back.bookStayApp.reserves.service;

import com.digitalbooking.back.bookStayApp.products.exception.BadRequestException;
import com.digitalbooking.back.bookStayApp.reserves.domain.Reserve;
import com.digitalbooking.back.bookStayApp.reserves.domain.ReserveRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CreateReserveService {
    @Autowired
    private ReserveRepository reserveRepository;

    public void handle(Reserve reserve) throws BadRequestException {
        log.info("Executing CreateReserveService.handle()");
        reserveRepository.save(reserve);
        log.info("Reserve created with id: {}", reserve.getId());
    }
}
