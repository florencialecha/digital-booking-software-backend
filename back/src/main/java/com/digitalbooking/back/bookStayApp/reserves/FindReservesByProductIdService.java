package com.digitalbooking.back.bookStayApp.reserves;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindReservesByProductIdService {

    @Autowired
    private ReserveRepository reserveRepository;

    public List<Reserve> handle(Long idProduct) {
        return reserveRepository.findByProductId(idProduct);
    }
}
