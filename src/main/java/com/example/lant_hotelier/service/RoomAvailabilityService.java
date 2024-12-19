package com.example.lant_hotelier.service;

import com.example.lant_hotelier.entities.Camera;
import com.example.lant_hotelier.repositories.RoomAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class RoomAvailabilityService {

    @Autowired
    private RoomAvailabilityRepository roomAvailabilityRepository;

    public List<Camera> getAvailableRooms(Short hotelId, LocalDate checkIn, LocalDate checkOut) {
        return roomAvailabilityRepository.findAvailableRooms(hotelId, checkIn, checkOut);
    }
}