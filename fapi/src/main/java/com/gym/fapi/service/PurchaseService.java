package com.gym.fapi.service;

import com.gym.fapi.models.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAll();

    Purchase getPurchaseById(Integer id);

    Purchase savePurchase(Purchase purchase);

    void deletePurchase(Integer id);
}
