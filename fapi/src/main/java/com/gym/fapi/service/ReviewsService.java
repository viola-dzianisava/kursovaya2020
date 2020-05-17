package com.gym.fapi.service;

import com.gym.fapi.models.Reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAll();

    Reviews getReviewsById(Integer id);

    Reviews saveReviews(Reviews reviews);

    void deleteReviews(Integer id);
}
