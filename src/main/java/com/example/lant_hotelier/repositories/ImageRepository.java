package com.example.lant_hotelier.repositories;

import com.example.lant_hotelier.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public interface ImageRepository extends JpaRepository<Image, Short> {
        List<Image> findByIdHotel(Short idHotel);
    }


