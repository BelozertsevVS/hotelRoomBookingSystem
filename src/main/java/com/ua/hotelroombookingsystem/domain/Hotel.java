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
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "Hotel_name")
    private String hotelName;
    @Column (name = "Hotel_address")
    private String hotelAddress;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

}
