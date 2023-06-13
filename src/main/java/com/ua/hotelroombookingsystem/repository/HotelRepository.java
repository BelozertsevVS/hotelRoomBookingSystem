package com.ua.hotelroombookingsystem.repository;

import com.ua.hotelroombookingsystem.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
