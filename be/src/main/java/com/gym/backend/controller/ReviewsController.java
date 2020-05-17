package com.gym.backend.controller;


import com.gym.backend.entity.ReviewsEntity;
import com.gym.backend.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

    private ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ReviewsEntity> getReviewsById(@PathVariable(name = "id") Integer id) {
        Optional<ReviewsEntity> reviewsEntity = reviewsService.getReviewsById(id);
        if (reviewsEntity.isPresent()) {
            return ResponseEntity.ok(reviewsEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ReviewsEntity> getAllReviews() {
        return reviewsService.getAllReviews();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ReviewsEntity saveReviews(@RequestBody ReviewsEntity reviews) {
        return reviewsService.saveReviews(reviews);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteReviews(@PathVariable(name = "id") Integer id) {
        reviewsService.deleteReviews(id);
    }
}
