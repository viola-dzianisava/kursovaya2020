package com.gym.backend.service.impl;

import com.gym.backend.entity.FaqEntity;
import com.gym.backend.entity.NewsEntity;
import com.gym.backend.repository.FaqRepository;
import com.gym.backend.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FaqServiceImpl implements FaqService {

    private FaqRepository repository;

    @Autowired
    public FaqServiceImpl(FaqRepository repository) {
        this.repository = repository;
    }

    @Override
    public FaqEntity saveFaq(FaqEntity faqEntity) {
        return repository.save(faqEntity);
    }

    @Override
    public Optional<FaqEntity> getFaqById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<FaqEntity> getAllFaq() {
        return repository.findAll();
    }

    @Override
    public void deleteFaq(Integer id) {
        repository.deleteById(id);
    }
}
