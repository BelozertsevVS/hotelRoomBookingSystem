package com.ua.hotelroombookingsystem.service;

import com.ua.hotelroombookingsystem.domain.Hotel;
import com.ua.hotelroombookingsystem.dto.HotelDto;
import com.ua.hotelroombookingsystem.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class HotelService {

    private final HotelRepository hotelRepository;

    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public Optional<Hotel> findById(Long id) {
        return hotelRepository.findById(id);
    }

    public List<HotelDto> findAll() {
        return hotelRepository.findAll().stream()
                .map(HotelService::buildHotelDto)
                .collect(Collectors.toList());
    }

    private static HotelDto buildHotelDto(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .hotelName(hotel.getHotelName())
                .hotelAddress(hotel.getHotelAddress())
                .build();
    }


}
