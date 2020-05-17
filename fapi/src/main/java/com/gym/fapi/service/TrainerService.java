package com.gym.fapi.service;


import com.gym.fapi.models.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> getAll();

    Trainer getTrainerById(Integer id);

    Trainer saveTrainer(Trainer ticket);

    void deleteTrainer(Integer id);
}
