package com.example.lant_hotelier.repositories;

import com.example.lant_hotelier.entities.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomAvailabilityRepository extends JpaRepository<Camera, Short> {

    @Query("SELECT c FROM Camera c WHERE c.idHotel = :hotelId AND c.idCamera NOT IN (" +
            "SELECT r.idCamera FROM Rezervare r WHERE r.checkInRezervare <= :checkOut AND r.checkOutRezervare >= :checkIn)")
    List<Camera> findAvailableRooms(@Param("hotelId") Short hotelId,
                                    @Param("checkIn") LocalDate checkIn,
                                    @Param("checkOut") LocalDate checkOut);
}