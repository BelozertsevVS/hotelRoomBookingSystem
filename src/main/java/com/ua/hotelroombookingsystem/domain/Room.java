package com.ua.hotelroombookingsystem.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "Room_number")
    private Integer roomNumber;
    @Column (name = "Room_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Column (name = "Capacity")
    private Integer capacity;
    @Column (name = "Floor_number")
    private Integer floorNumber;
    @Column (name = "Room_description")
    private String roomDescription;
    @Column (name = "Price_per_night")
    private Integer pricePerNight;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany (mappedBy = "room")
    private List<Reservation> reservations;








}
