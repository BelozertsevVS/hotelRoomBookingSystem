package com.ua.hotelroombookingsystem.rest;

import com.ua.hotelroombookingsystem.domain.Hotel;
import com.ua.hotelroombookingsystem.dto.HotelDto;
import com.ua.hotelroombookingsystem.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class HotelController {

    private final HotelService hotelService;
    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDto>> findAll() {
        return ResponseEntity.ok(hotelService.findAll());
    }
    @PostMapping("/hotels")
    public ResponseEntity<Void> save(@RequestBody Hotel hotel) {
        hotelService.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




}
