package com.example.lant_hotelier.controllers;

import com.example.lant_hotelier.entities.Facilitate;
import com.example.lant_hotelier.service.FacilitateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FacilitateController {
    @Autowired
    private FacilitateService facilitateService;

    @GetMapping("/services")
    public String getFacilitati(Model model) {
        List<Facilitate> facilitati = facilitateService.getUniqueFacilitati();
        model.addAttribute("facilitati", facilitati);
        return "services";
    }
}