package com.example.lant_hotelier.controllers;

import com.example.lant_hotelier.entities.Camera;
import com.example.lant_hotelier.entities.Facilitate;
import com.example.lant_hotelier.entities.Hotel;
import com.example.lant_hotelier.entities.Image;
import com.example.lant_hotelier.service.CameraService;
import com.example.lant_hotelier.service.FacilitateService;
import com.example.lant_hotelier.service.HotelService;
import com.example.lant_hotelier.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

        model.addAttribute("hotel", hotel);
        model.addAttribute("camere", camere);
        model.addAttribute("facilitati", facilitati);
        model.addAttribute("images", images);

        return "hotel-details";
    }
}