package com.ua.hotelroombookingsystem.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GuestDto {
    private Long id;
    private String surname;
    private String firstName;
    private String middleName;
    private Long individualTaxNumber;
    private String passportId;
    private String email;
    private String phoneNumber;
}
