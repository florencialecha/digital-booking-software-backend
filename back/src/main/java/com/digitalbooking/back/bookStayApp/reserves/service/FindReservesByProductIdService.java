package com.digitalbooking.back.bookStayApp.reserves.service;

import com.digitalbooking.back.bookStayApp.reserves.domain.Reserve;
import com.digitalbooking.back.bookStayApp.reserves.domain.ReserveRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class FindReservesByProductIdService {
    @Autowired
    private ReserveRepository reserveRepository;
    public List<Reserve> handle(Long idProduct) {
        log.info("Executing FindReservesByProductIdService.handle()");
        List<Reserve> reserves = reserveRepository.findByProductId(idProduct);
        log.info("Found {} reserves", reserves.size());
        return reserves;
    }
}
