package com.example.lant_hotelier.repositories;

import com.example.lant_hotelier.entities.Facilitate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FacilitateRepository extends JpaRepository<Facilitate, Short> {

    @Query("""
        SELECT f FROM Facilitate f
        JOIN f.oferte o
        WHERE o.hotel.idHotel = :idHotel
        """)
    List<Facilitate> findByHotelId(@Param("idHotel") Short idHotel);
}