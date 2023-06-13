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

public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Surname", nullable = false)
    private String surname;
    @Column(name = "First_name", nullable = false)
    private String firstName;
    @Column(name = "Middle_name")
    private String middleName;
    @Column(name = "Individual_tax_number")
    private Long individualTaxNumber;
    @Column(name = "Passport_ID")
    private String passportId;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone_number")
    private String phoneNumber;

    @OneToMany (mappedBy = "guest")
    private List<Reservation> reservations;


}
