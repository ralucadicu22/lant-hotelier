package com.example.lant_hotelier.controllers;

import com.example.lant_hotelier.entities.Hotel;
import com.example.lant_hotelier.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class HomeController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels", hotels);
        System.out.println(hotels);
        return "index";

    }

}