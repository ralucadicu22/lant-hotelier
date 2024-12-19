package com.example.lant_hotelier.service;


import com.example.lant_hotelier.entities.Camera;
import com.example.lant_hotelier.entities.Facilitate;
import com.example.lant_hotelier.entities.Hotel;
import com.example.lant_hotelier.repositories.CameraRepository;
import com.example.lant_hotelier.repositories.FacilitateRepository;
import com.example.lant_hotelier.repositories.HotelRepository;
import com.example.lant_hotelier.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Short id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }
}