package com.example.lant_hotelier.service;

import com.example.lant_hotelier.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // În memorie, păstrăm numărul total de recenzii și suma lor pentru fiecare hotel
    private final Map<Short, Double> sumRatings = new HashMap<>();
    private final Map<Short, Integer> countRatings = new HashMap<>();

    public void addReview(Short idHotel, Double rating) {

        sumRatings.put(idHotel, sumRatings.getOrDefault(idHotel, 0.0) + rating);
        countRatings.put(idHotel, countRatings.getOrDefault(idHotel, 0) + 1);

        double average = sumRatings.get(idHotel) / countRatings.get(idHotel);
        reviewRepository.updateAverageRating(idHotel, average);
    }

    public Double getAverageRating(Short idHotel) {
        return sumRatings.getOrDefault(idHotel, 0.0) / countRatings.getOrDefault(idHotel, 1);
    }
}