package com.gym.backend.service;

import com.gym.backend.entity.PurchaseEntity;

import java.util.Optional;

public interface PurchaseService {
    PurchaseEntity savePurchase(PurchaseEntity purchaseEntity);

    Optional<PurchaseEntity> getPurchaseById(Integer id);

    Iterable<PurchaseEntity> getAllPurchase();

    void deletePurchase(Integer id);
}
