package com.ua.hotelroombookingsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder

public class ReservationRequestDto {
    private Long roomId;
    private Long guestID;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
