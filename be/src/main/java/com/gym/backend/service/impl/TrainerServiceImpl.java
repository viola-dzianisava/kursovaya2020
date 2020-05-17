package com.gym.backend.service.impl;

import com.gym.backend.entity.TicketEntity;
import com.gym.backend.entity.TrainerEntity;
import com.gym.backend.repository.TicketRepository;
import com.gym.backend.repository.TrainerRepository;
import com.gym.backend.service.TicketService;
import com.gym.backend.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TrainerServiceImpl implements TrainerService {

    private TrainerRepository repository;

    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.repository = trainerRepository;
    }

    @Override
    public TrainerEntity saveTrainer(TrainerEntity trainerEntity) {
        return repository.save(trainerEntity);
    }

    @Override
    public Optional<TrainerEntity> getTrainerById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<TrainerEntity> getAllTrainer() {
        return repository.findAll();
    }

    @Override
    public void deleteTrainer(Integer id) {
        repository.deleteById(id);
    }
}
