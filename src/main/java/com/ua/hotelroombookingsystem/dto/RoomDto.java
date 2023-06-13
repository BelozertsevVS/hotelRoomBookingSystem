package com.ua.hotelroombookingsystem.dto;

import com.ua.hotelroombookingsystem.domain.Hotel;
import com.ua.hotelroombookingsystem.domain.RoomType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class RoomDto {

    private Long id;
    private Integer roomNumber;
    private RoomType roomType;
    private Integer capacity;
    private Integer floorNumber;
    private String roomDescription;
    private Integer pricePerNight;

    private String hotelName;
}
