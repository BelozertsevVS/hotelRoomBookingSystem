package com.ua.hotelroombookingsystem.service;

import com.ua.hotelroombookingsystem.domain.Guest;
import com.ua.hotelroombookingsystem.domain.Reservation;
import com.ua.hotelroombookingsystem.domain.ReservationStatus;
import com.ua.hotelroombookingsystem.domain.Room;
import com.ua.hotelroombookingsystem.dto.ReservationDto;
import com.ua.hotelroombookingsystem.dto.ReservationIdDto;
import com.ua.hotelroombookingsystem.dto.ReservationRequestDto;
import com.ua.hotelroombookingsystem.dto.RoomDto;
import com.ua.hotelroombookingsystem.repository.GuestRepository;
import com.ua.hotelroombookingsystem.repository.ReservationRepository;
import com.ua.hotelroombookingsystem.repository.RoomRepository;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public Optional<Reservation> FindById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<ReservationDto> findAll() {
        return reservationRepository.findAll().stream()
                .map(ReservationService::buildReservationDto)
                .collect(Collectors.toList());

    }

//    public List<RoomDto> findFreeRooms(ReservationRequestDto reservationRequestDto) {
//        Long roomId = reservationRequestDto.getRoomId();
//        LocalDate checkInDate = reservationRequestDto.getCheckInDate();
//        LocalDate checkOutDate = reservationRequestDto.getCheckOutDate();
//
//        return reservationRepository.findFreeRooms(roomId, checkInDate, checkOutDate).stream()
//                .map()
//
//    }

    public void makeReservation(ReservationRequestDto reservationRequestDto) {
        Room room = roomRepository.findById(reservationRequestDto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        Guest guest = guestRepository.findById(reservationRequestDto.getGuestID())
                .orElseThrow(() -> new RuntimeException("Guest not found"));

        Reservation reservation = new Reservation();
        reservation.setRoom(room);
        reservation.setGuest(guest);
        reservation.setCheckInDate(reservationRequestDto.getCheckInDate());
        reservation.setCheckOutDate(reservationRequestDto.getCheckOutDate());
        reservation.setReservationStatus(ReservationStatus.valueOf(ReservationStatus.ACTIVE.name()));

        this.save(reservation);

    }

    public void cancelReservation(ReservationIdDto reservationIdDto) {
        Reservation reservation = reservationRepository.findById(reservationIdDto.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation.setReservationStatus(ReservationStatus.valueOf(ReservationStatus.CANCELED.name()));
        this.save(reservation);
    }


    private static ReservationDto buildReservationDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .checkInDate(reservation.getCheckInDate())
                .checkOutDate(reservation.getCheckOutDate())
                .roomNumber(reservation.getRoom().getRoomNumber())
                .surname(reservation.getGuest().getSurname())
                .firstName(reservation.getGuest().getFirstName())
                .middleName(reservation.getGuest().getMiddleName())
                .reservationStatus(reservation.getReservationStatus())
                .build();
    }

}

