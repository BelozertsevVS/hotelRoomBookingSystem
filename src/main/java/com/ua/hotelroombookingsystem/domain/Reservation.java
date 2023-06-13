package com.ua.hotelroombookingsystem.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Check-in_date")
    private LocalDate checkInDate;
    @Column (name = "Check-out_date")
    private LocalDate checkOutDate;
    @Column (name = "Reservation_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @ManyToOne
    @JoinColumn (name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn (name = "guest_id")
    private Guest guest;




}
