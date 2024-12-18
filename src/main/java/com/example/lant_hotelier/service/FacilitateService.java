package com.example.lant_hotelier.service;


import com.example.lant_hotelier.entities.Facilitate;
import com.example.lant_hotelier.repositories.FacilitateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacilitateService {
    @Autowired
    private FacilitateRepository facilitateRepository;

    public List<Facilitate> getUniqueFacilitati() {
        return facilitateRepository.findAll().stream()
                .distinct()
                .collect(Collectors.toList());
    }
}