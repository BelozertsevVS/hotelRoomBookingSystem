package com.ua.hotelroombookingsystem.rest;

import com.ua.hotelroombookingsystem.domain.Reservation;
import com.ua.hotelroombookingsystem.dto.ReservationDto;
import com.ua.hotelroombookingsystem.dto.ReservationIdDto;
import com.ua.hotelroombookingsystem.dto.ReservationRequestDto;
import com.ua.hotelroombookingsystem.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDto>> findAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PostMapping("/reservations")
    public ResponseEntity<Void> save(@RequestBody Reservation reservation) {
        reservationService.save(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/reservation/make")
    public ResponseEntity<Void> makeReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        reservationService.makeReservation(reservationRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/reservation/cancel")
    public ResponseEntity<Void> cancelReservation(@RequestBody ReservationIdDto reservationIdDto) {
        reservationService.cancelReservation(reservationIdDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
