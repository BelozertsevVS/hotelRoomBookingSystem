package com.ua.hotelroombookingsystem.repository;

import com.ua.hotelroombookingsystem.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
