package com.digitalbooking.back.bookStayApp.reserves.dto;

import com.digitalbooking.back.bookStayApp.products.dto.ProductToFindDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ReservesUserDTO {
    private Long idReserve;
    private String productName;
    private LocalTime startTime;
    private LocalDate checkIn;
    private LocalDate checkOut;

}
