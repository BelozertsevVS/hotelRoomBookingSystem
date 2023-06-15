package com.ua.hotelroombookingsystem.repository;

import com.ua.hotelroombookingsystem.domain.Reservation;
import com.ua.hotelroombookingsystem.domain.Room;
import com.ua.hotelroombookingsystem.dto.RoomDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


//    @Query(value = "SELECT * FROM reservation WHERE room_id = :roomId AND " +
//            "((`Check-in_date` < :checkInDate AND `Check-out_date` < :checkOutDate) OR " +
//            "(`Check-in_date` > :checkInDate AND `Check-out_date` < :checkOutDate)) " +
//            "AND :checkOutDate >= CURDATE()", nativeQuery = true)
//    List<Room> findFreeRooms(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);

//    @Query(value = "SELECT r.* FROM room r " +
//            "LEFT JOIN reservation res ON r.id = res.room_id " +
//            "AND ((`Check-in_date` < :checkInDate AND `Check-out_date` < :checkOutDate) OR " +
//            "(`Check-in_date` > :checkInDate AND `Check-out_date` < :checkOutDate)) " +
//            "WHERE res.room_id IS NULL " +
//            "AND :checkOutDate >= CURDATE()", nativeQuery = true)
//    List<Room> findFreeRooms(LocalDate checkInDate, LocalDate checkOutDate);
//
//    @Query(value = "SELECT r.* FROM room r " +
//            "LEFT JOIN reservation res ON r.id = res.room_id " +
//            "AND ((res.`Check-in_date` < :checkInDate AND res.`Check-out_date` > :checkInDate) OR " +
//            "(res.`Check-in_date` < :checkOutDate AND res.`Check-out_date` > :checkOutDate) OR " +
//            "(res.`Check-in_date` >= :checkInDate AND res.`Check-out_date` <= :checkOutDate)) " +
//            "WHERE res.room_id IS NULL " +
//            "AND :checkInDate >= CURDATE() " +
//            "AND :checkOutDate >= :checkInDate", nativeQuery = true)
//    List<Room> findFreeRooms(LocalDate checkInDate, LocalDate checkOutDate);

//    @Query(value = "SELECT r.* FROM room r " +
//            "WHERE r.id NOT IN (" +
//            "SELECT res.room_id FROM reservation res " +
//            "WHERE (res.`Check-in_date` < :checkInDate AND res.`Check-out_date` > :checkInDate) OR " +
//            "(res.`Check-in_date` < :checkOutDate AND res.`Check-out_date` > :checkOutDate) OR " +
//            "(res.`Check-in_date` >= :checkInDate AND res.`Check-out_date` <= :checkOutDate)) " +
//            "AND :checkInDate >= CURDATE() " +
//            "AND :checkOutDate >= :checkInDate", nativeQuery = true)
//    List<Room> findFreeRooms(LocalDate checkInDate, LocalDate checkOutDate);

    @Query(value = "SELECT r.* FROM room r " +
            "WHERE r.id NOT IN (" +
            "SELECT res.room_id FROM reservation res " +
            "WHERE NOT(res.`Check-out_date` <= :checkInDate OR res.`Check-in_date` >= :checkOutDate)) " +
            "AND :checkInDate >= CURDATE() " +
            "AND :checkOutDate >= :checkInDate", nativeQuery = true)
    List<Room> findFreeRooms(LocalDate checkInDate, LocalDate checkOutDate);



}



