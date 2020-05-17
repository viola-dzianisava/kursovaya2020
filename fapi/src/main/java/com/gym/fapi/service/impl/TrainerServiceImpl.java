package com.gym.fapi.service.impl;


import com.gym.fapi.models.Trainer;
import com.gym.fapi.service.TrainerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class TrainerServiceImpl implements TrainerService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Trainer> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Trainer[] trainerResponse = restTemplate.getForObject(backendServerUrl + "/api/trainer/", Trainer[].class);
        return trainerResponse == null ? Collections.emptyList() : Arrays.asList(trainerResponse);
    }

    @Override
    public Trainer getTrainerById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/trainer/" + id, Trainer.class);
    }

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/trainer", trainer, Trainer.class).getBody();
    }

    @Override
    public void deleteTrainer(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/trainer/" + id);
    }
}
