package com.example.lant_hotelier.service;

import com.example.lant_hotelier.entities.Camera;
import com.example.lant_hotelier.repositories.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {

    @Autowired
    private CameraRepository cameraRepository;



    public List<Camera> getCamereByHotelId(Short idHotel) {
        return cameraRepository.findByHotelId(idHotel);
    }
}