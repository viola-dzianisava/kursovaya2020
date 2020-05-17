package com.gym.fapi.controller;

import com.gym.fapi.models.News;
import com.gym.fapi.models.Reviews;
import com.gym.fapi.service.NewsService;
import com.gym.fapi.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @RequestMapping
    public ResponseEntity<List<Reviews>> getAllReviews() {
        return ResponseEntity.ok(reviewsService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Reviews> saveReviews(@RequestBody Reviews reviews /*todo server validation*/) {
        if (reviews != null) {
            return ResponseEntity.ok(reviewsService.saveReviews(reviews));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteReviews(@PathVariable String id) {
        reviewsService.deleteReviews(Integer.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Reviews> getAllReviews(@PathVariable String id) throws InterruptedException {
        int reviewsId = Integer.valueOf(id);
        return ResponseEntity.ok(reviewsService.getReviewsById(reviewsId));
    }
}
