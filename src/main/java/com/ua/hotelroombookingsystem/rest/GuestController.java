package com.ua.hotelroombookingsystem.rest;

import com.ua.hotelroombookingsystem.domain.Guest;
import com.ua.hotelroombookingsystem.dto.GuestDto;
import com.ua.hotelroombookingsystem.dto.GuestPassportIdDto;
import com.ua.hotelroombookingsystem.dto.GuestSurnameDto;
import com.ua.hotelroombookingsystem.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor

public class GuestController {

    private final GuestService guestService;

    @GetMapping("/guests")
    public ResponseEntity<List<GuestDto>> findAll() {
        return ResponseEntity.ok(guestService.findAll());
    }

    @GetMapping("/guest/find/by/surname")
    public ResponseEntity<List<GuestDto>> findGuestBySurname(GuestSurnameDto guestSurnameDto) {
        return ResponseEntity.ok(guestService.findGuestBySurname(guestSurnameDto));
    }
    @GetMapping("/guest/find/by/passport")
    public ResponseEntity<GuestDto> findGuestByPassportId (GuestPassportIdDto guestPassportIdDto) {
        return ResponseEntity.ok(guestService.findGuestByPassportId(guestPassportIdDto));
    }

    @PostMapping("/guests")
    public ResponseEntity<Void> save(@RequestBody Guest guest) {
        guestService.save(guest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
