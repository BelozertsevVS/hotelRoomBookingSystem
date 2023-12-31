package com.ua.hotelroombookingsystem.repository;

import com.ua.hotelroombookingsystem.domain.Guest;
import com.ua.hotelroombookingsystem.dto.GuestDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
     @Cacheable("false")
     @Query(value = "SELECT * FROM guest WHERE surname LIKE :surname", nativeQuery = true)
     List<Guest> findGuestBySurname(@Param("surname") String surname);

     @Cacheable("false")
     @Query(value = "SELECT * FROM guest WHERE passport_id = :passportId", nativeQuery = true)
     Guest findGuestByPassportId(@Param("passportId") String passportId);

}
