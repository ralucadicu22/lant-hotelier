package com.example.lant_hotelier.service;
import com.example.lant_hotelier.entities.Image;
import com.example.lant_hotelier.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getImagesByHotelId(Short hotelId) {
        return imageRepository.findByIdHotel(hotelId);
    }


    public Image addImage(Image image) {
        return imageRepository.save(image);
    }


    public void deleteImageById(Short imageId) {
        imageRepository.deleteById(imageId);
    }

    public void deleteImagesByHotelId(Short hotelId) {
        List<Image> images = imageRepository.findByIdHotel(hotelId);
        imageRepository.deleteAll(images);
    }
}