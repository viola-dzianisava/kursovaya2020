package com.gym.backend.service;


import com.gym.backend.entity.FaqEntity;

import java.util.Optional;

public interface FaqService {

    FaqEntity saveFaq(FaqEntity faqEntity);

    Optional<FaqEntity> getFaqById(Integer id);

    Iterable<FaqEntity> getAllFaq();

    void deleteFaq(Integer id);
}