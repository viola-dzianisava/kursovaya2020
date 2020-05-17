package com.gym.backend.repository;

import com.gym.backend.entity.ReviewsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends CrudRepository<ReviewsEntity, Integer> {
}
