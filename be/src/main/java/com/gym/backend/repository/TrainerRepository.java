package com.gym.backend.repository;

import com.gym.backend.entity.TrainerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TrainerRepository extends CrudRepository<TrainerEntity, Integer> {
}
