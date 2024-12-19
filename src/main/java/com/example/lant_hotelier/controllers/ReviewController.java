package com.example.lant_hotelier.controllers;



import com.example.lant_hotelier.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<String> addReview(
            @RequestParam("idHotel") Short idHotel,
            @RequestParam("rating") Double rating) {
        reviewService.addReview(idHotel, rating);
        return ResponseEntity.ok("Review added successfully!");
    }

    @GetMapping("/average")
    public ResponseEntity<Double> getAverageRating(@RequestParam("idHotel") Short idHotel) {
        Double averageRating = reviewService.getAverageRating(idHotel);
        return ResponseEntity.ok(averageRating);
    }
}