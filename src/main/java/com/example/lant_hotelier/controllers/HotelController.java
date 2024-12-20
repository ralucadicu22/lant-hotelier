package com.example.lant_hotelier.controllers;

import com.example.lant_hotelier.entities.*;
import com.example.lant_hotelier.repositories.BookingRepository;
import com.example.lant_hotelier.service.CameraService;
import com.example.lant_hotelier.service.FacilitateService;
import com.example.lant_hotelier.service.HotelService;
import com.example.lant_hotelier.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Controller
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CameraService cameraService;

    @Autowired
    private FacilitateService facilitateService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/hotel")
    public String showHotels(Model model) {
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotel";
    }

    @GetMapping("/hotel/details/{id}")
    public String showHotelDetails(@PathVariable("id") Short id, Model model) {
        Hotel hotel = hotelService.getHotelById(id);
        List<Camera> camere = cameraService.getCamereByHotelId(id);
        List<Facilitate> facilitati = facilitateService.getFacilitatiByHotelId(id);
        List<Image> images = imageService.getImagesByHotelId(id);
        List<Rezervare> rezervari = bookingRepository.findByHotelIdAndCurrentDate(id, LocalDate.now());

        for (Rezervare rezervare : rezervari) {
            Camera camera = camere.stream()
                    .filter(cam -> cam.getIdCamera().equals(rezervare.getIdCamera()))
                    .findFirst()
                    .orElse(null);

            if (camera != null) {
                long numarNopti = ChronoUnit.DAYS.between(rezervare.getCheckInRezervare(), rezervare.getCheckOutRezervare());
                rezervare.setPretTotal(numarNopti * camera.getPretNoapteCamera().doubleValue());
            }
        }
        model.addAttribute("hotel", hotel);
        model.addAttribute("camere", camere);
        model.addAttribute("facilitati", facilitati);
        model.addAttribute("images", images);
        model.addAttribute("rezervari", rezervari);

        return "hotel-details";
    }
}