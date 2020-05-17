package com.gym.backend.service.impl;


import com.gym.backend.entity.PurchaseEntity;
import com.gym.backend.repository.PurchaseRepository;
import com.gym.backend.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepository repository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseEntity savePurchase(PurchaseEntity purchaseEntity) {
        return repository.save(purchaseEntity);
    }

    @Override
    public Optional<PurchaseEntity> getPurchaseById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<PurchaseEntity> getAllPurchase() {
        return repository.findAll();
    }

    @Override
    public void deletePurchase(Integer id) {
        repository.deleteById(id);
    }
}
