package com.gym.backend.service;

import com.gym.backend.entity.ReviewsEntity;

import java.util.Optional;

public interface ReviewsService {

    ReviewsEntity saveReviews(ReviewsEntity reviewsEntity);

    Optional<ReviewsEntity> getReviewsById(Integer id);

    Iterable<ReviewsEntity> getAllReviews();

    void deleteReviews(Integer id);
}