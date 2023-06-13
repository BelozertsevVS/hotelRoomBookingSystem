package com.ua.hotelroombookingsystem.rest;

import com.ua.hotelroombookingsystem.domain.Room;
import com.ua.hotelroombookingsystem.dto.ReservationRequestDto;
import com.ua.hotelroombookingsystem.dto.RoomDto;
import com.ua.hotelroombookingsystem.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor

public class RoomController {

    private final RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping("/rooms/find/free")
    public ResponseEntity<List<RoomDto>> findFreeRooms(@RequestBody ReservationRequestDto reservationRequestDto) {
        return ResponseEntity.ok(roomService.findFreeRooms(reservationRequestDto));
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Optional<Room>> findById(Long id) {
        return ResponseEntity.ok(roomService.findById(id));
    }

    @PostMapping("/rooms")
    public ResponseEntity<Void> save(@RequestBody Room room) {
        roomService.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/delete/room/{id}")
    public  ResponseEntity<Void> deleteRoom (@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/update/room")
    public ResponseEntity<Void> updateRoomInformation (@RequestBody RoomDto roomDto) {
        roomService.updateRoomInformation(roomDto);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }




}
