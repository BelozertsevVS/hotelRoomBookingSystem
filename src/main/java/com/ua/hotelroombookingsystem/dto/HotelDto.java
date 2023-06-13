package com.ua.hotelroombookingsystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class HotelDto {

    private Long id;
    private String hotelName;
    private String hotelAddress;
}
