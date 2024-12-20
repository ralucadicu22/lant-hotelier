package com.example.lant_hotelier.repositories;

import com.example.lant_hotelier.entities.Rezervare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Rezervare, Short> {

    @Query("SELECT r FROM Rezervare r WHERE r.idCamera = :roomId AND r.checkOutRezervare >= :currentDate")
    List<Rezervare> findActiveBookingsForRoom(@Param("roomId") Short roomId, @Param("currentDate") LocalDate currentDate);
    @Query("SELECT r FROM Rezervare r WHERE r.idHotel = :hotelId AND r.checkInRezervare >= :currentDate")
    List<Rezervare> findByHotelIdAndCurrentDate(@Param("hotelId") Short hotelId, @Param("currentDate") LocalDate currentDate);
}