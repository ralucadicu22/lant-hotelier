package com.example.lant_hotelier.controllers;

import com.example.lant_hotelier.entities.Hotel;
import com.example.lant_hotelier.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel")
    public String showHotels(Model model) {
        List<Hotel> hoteluri = hotelService.getAllHotels();
        model.addAttribute("hotels", hoteluri);
        System.out.println(hoteluri);
        return "hotel";
    }
}