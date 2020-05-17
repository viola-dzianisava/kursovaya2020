package com.gym.backend.controller;

import com.gym.backend.entity.TrainerEntity;
import com.gym.backend.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    private TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TrainerEntity> getTrainerById(@PathVariable(name = "id") Integer id) {
        Optional<TrainerEntity> trainerEntity = trainerService.getTrainerById(id);
        if (trainerEntity.isPresent()) {
            return ResponseEntity.ok(trainerEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<TrainerEntity> getAllTrainer() {
        return trainerService.getAllTrainer();
    }

    @RequestMapping(method = RequestMethod.POST)
    public TrainerEntity saveTrainer(@RequestBody TrainerEntity trainerEntity) {
        return trainerService.saveTrainer(trainerEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTrainer(@PathVariable(name = "id") Integer id) {
        trainerService.deleteTrainer(id);
    }
}
