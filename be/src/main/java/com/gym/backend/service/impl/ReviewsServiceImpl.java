package com.gym.backend.service.impl;

import com.gym.backend.entity.ReviewsEntity;
import com.gym.backend.repository.ReviewsRepository;
import com.gym.backend.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewsServiceImpl implements ReviewsService {

    private ReviewsRepository repository;

    @Autowired
    public ReviewsServiceImpl(ReviewsRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReviewsEntity saveReviews(ReviewsEntity reviewsEntity) {
        return repository.save(reviewsEntity);
    }

    @Override
    public Optional<ReviewsEntity> getReviewsById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<ReviewsEntity> getAllReviews() {
        return repository.findAll();
    }

    @Override
    public void deleteReviews(Integer id) {
        repository.deleteById(id);
    }
}
