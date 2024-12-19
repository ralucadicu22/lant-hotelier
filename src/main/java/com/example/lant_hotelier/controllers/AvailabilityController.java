package com.example.lant_hotelier.controllers;

import com.example.lant_hotelier.entities.Camera;
import com.example.lant_hotelier.service.RoomAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private RoomAvailabilityService roomAvailabilityService;

    @GetMapping
    public ResponseEntity<List<Camera>> checkAvailability(
            @RequestParam("hotelId") Short hotelId,
            @RequestParam("checkIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut) {
        List<Camera> availableRooms = roomAvailabilityService.getAvailableRooms(hotelId, checkIn, checkOut);

        return ResponseEntity.ok(availableRooms);
    }
}