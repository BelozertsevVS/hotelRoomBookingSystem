package com.ua.hotelroombookingsystem.repository;

import com.ua.hotelroombookingsystem.domain.Reservation;
import com.ua.hotelroombookingsystem.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query(value = "SELECT * FROM reservation WHERE room_id = :roomId AND " +
            "((`Check-in_date` < :checkInDate AND `Check-out_date` < :checkOutDate) OR " +
            "(`Check-in_date` > :checkInDate AND `Check-out_date` < :checkOutDate)) " +
            "AND :checkOutDate >= CURDATE()", nativeQuery = true)
    List<Room> findFreeRooms(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);




}



