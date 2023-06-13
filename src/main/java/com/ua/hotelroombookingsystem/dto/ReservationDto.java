package com.ua.hotelroombookingsystem.dto;

import com.ua.hotelroombookingsystem.domain.Guest;
import com.ua.hotelroombookingsystem.domain.ReservationStatus;
import com.ua.hotelroombookingsystem.domain.Room;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder

public class ReservationDto {

    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationStatus reservationStatus;

    private Integer roomNumber;

    private String surname;
    private String firstName;
    private String middleName;

}
