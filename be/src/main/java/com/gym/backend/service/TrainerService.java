package com.gym.backend.service;

import com.gym.backend.entity.TrainerEntity;

import java.util.Optional;

public interface TrainerService {

    TrainerEntity saveTrainer(TrainerEntity trainerEntity);

    Optional<TrainerEntity> getTrainerById(Integer id);

    Iterable<TrainerEntity> getAllTrainer();

    void deleteTrainer(Integer id);
}
