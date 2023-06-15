package com.ua.hotelroombookingsystem.service;

import com.ua.hotelroombookingsystem.domain.Room;
import com.ua.hotelroombookingsystem.dto.ReservationRequestDto;
import com.ua.hotelroombookingsystem.dto.RoomDto;
import com.ua.hotelroombookingsystem.repository.HotelRepository;
import com.ua.hotelroombookingsystem.repository.ReservationRepository;
import com.ua.hotelroombookingsystem.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ReservationRepository reservationRepository;

    public void save(Room room) {
        roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    public List<RoomDto> findAll() {
        return roomRepository.findAll().stream()
                .map(RoomService::buildRoomDto)
                .collect(Collectors.toList());
    }

    public List<RoomDto> findFreeRooms(ReservationRequestDto reservationRequestDto) {
        Long roomId = reservationRequestDto.getRoomId();
        LocalDate checkInDate = reservationRequestDto.getCheckInDate();
        LocalDate checkOutDate = reservationRequestDto.getCheckOutDate();
       return reservationRepository.findFreeRooms(checkInDate, checkOutDate).stream()
               .map(RoomService::buildRoomDto)
                .collect(Collectors.toList());


    }

    public void updateRoomInformation(RoomDto roomDto) {
        Room room = roomRepository.findById(roomDto.getId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setRoomNumber(roomDto.getRoomNumber());
        room.setRoomType(roomDto.getRoomType());
        room.setCapacity(roomDto.getCapacity());
        room.setRoomDescription(roomDto.getRoomDescription());
        room.setPricePerNight(roomDto.getPricePerNight());
        room.setFloorNumber(roomDto.getFloorNumber());

        this.save(room);
    }


    private static RoomDto buildRoomDto(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .roomType(room.getRoomType())
                .capacity(room.getCapacity())
                .floorNumber(room.getFloorNumber())
                .roomDescription(room.getRoomDescription())
                .pricePerNight(room.getPricePerNight())
                .hotelName(room.getHotel().getHotelName())
                .build();
    }

}

