package com.ua.hotelroombookingsystem.service;

import com.ua.hotelroombookingsystem.domain.Guest;
import com.ua.hotelroombookingsystem.domain.Room;
import com.ua.hotelroombookingsystem.dto.GuestDto;
import com.ua.hotelroombookingsystem.dto.GuestPassportIdDto;
import com.ua.hotelroombookingsystem.dto.GuestSurnameDto;
import com.ua.hotelroombookingsystem.dto.RoomDto;
import com.ua.hotelroombookingsystem.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class GuestService {

    private final GuestRepository guestRepository;


    public void save(Guest guest) {
        guestRepository.save(guest);
    }

    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }



    public List<GuestDto> findGuestBySurname(GuestSurnameDto guestSurnameDto) {

        List<Guest> guests = guestRepository.findGuestBySurname(guestSurnameDto.getSurname());
        return guests.stream()
                .map(GuestService::buildGuestDto)
                .collect(Collectors.toList());
    }

    public GuestDto findGuestByPassportId (GuestPassportIdDto guestPassportIdDto) {
        String passportId = guestPassportIdDto.getPassportId();
        Guest guest = guestRepository.findGuestByPassportId(passportId);
        return buildGuestDto(guest);
    }

    public List<GuestDto> findAll() {
        return guestRepository.findAll().stream()
                .map(GuestService::buildGuestDto)
                .collect(Collectors.toList());
    }

    public void updateGuestInformation (GuestDto guestDto) {
        Guest guest = guestRepository.findById(guestDto.getId())
                .orElseThrow(() -> new RuntimeException("Guest not found"));

        guest.setSurname(guestDto.getSurname());
        guest.setFirstName(guestDto.getFirstName());
        guest.setMiddleName(guestDto.getMiddleName());
        guest.setIndividualTaxNumber(guestDto.getIndividualTaxNumber());
        guest.setPassportId(guestDto.getPassportId());
        guest.setEmail(guestDto.getEmail());
        guest.setPhoneNumber(guestDto.getPhoneNumber());

        this.save(guest);
    }

    private static GuestDto buildGuestDto(Guest guest) {
        if (guest == null) {
            return null;
        }
        return GuestDto.builder()
                .id(guest.getId())
                .surname(guest.getSurname())
                .firstName(guest.getFirstName())
                .middleName(guest.getMiddleName())
                .individualTaxNumber(guest.getIndividualTaxNumber())
                .passportId(guest.getPassportId())
                .email(guest.getEmail())
                .phoneNumber(guest.getPhoneNumber())
                .build();
    }
}
