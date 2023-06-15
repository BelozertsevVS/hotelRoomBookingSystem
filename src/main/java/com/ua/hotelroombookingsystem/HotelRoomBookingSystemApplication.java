package com.ua.hotelroombookingsystem;

import com.ua.hotelroombookingsystem.dto.GuestPassportIdDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HotelRoomBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelRoomBookingSystemApplication.class, args);
    }


}
