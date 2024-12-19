package com.example.lant_hotelier.repositories;

import com.example.lant_hotelier.entities.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Short> {
    @Query("SELECT c FROM Camera c WHERE c.idHotel = :idHotel")
    List<Camera> findByHotelId(@Param("idHotel") Short idHotel);
}