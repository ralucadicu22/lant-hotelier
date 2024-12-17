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

    @GetMapping("/hotel")    // URL-ul pe care îl vei apela din meniu
    public String showHotels(Model model) {
        // 1. Ia lista de hoteluri din service
        List<Hotel> hoteluri = hotelService.getAllHotels();

        // 2. Pune lista în model, ca să fie accesibilă în Thymeleaf
        model.addAttribute("hotels", hoteluri);
        System.out.println(hoteluri);
        // 3. Returnează numele fișierului HTML (hotel.html) din /templates
        return "hotel";
    }
}