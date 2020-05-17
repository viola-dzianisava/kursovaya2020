package com.gym.fapi.controller;

import com.gym.fapi.models.Trainer;
import com.gym.fapi.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @RequestMapping
    public ResponseEntity<List<Trainer>> getAllReviews() {
        return ResponseEntity.ok(trainerService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Trainer> saveTrainer(@RequestBody Trainer trainer /*todo server validation*/) {
        if (trainer != null) {
            return ResponseEntity.ok(trainerService.saveTrainer(trainer));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTrainer(@PathVariable String id) {
        trainerService.deleteTrainer(Integer.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Trainer> getAllTrainer(@PathVariable String id) throws InterruptedException {
        int trainerId = Integer.valueOf(id);
        return ResponseEntity.ok(trainerService.getTrainerById(trainerId));
    }
}
