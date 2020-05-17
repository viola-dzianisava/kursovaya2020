package com.gym.fapi.service.impl;

import com.gym.fapi.models.Purchase;
import com.gym.fapi.service.PurchaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class PurchaseServiceImpl implements PurchaseService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Purchase> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Purchase[] purchaseResponse = restTemplate.getForObject(backendServerUrl + "/api/purchase/", Purchase[].class);
        return purchaseResponse == null ? Collections.emptyList() : Arrays.asList(purchaseResponse);
    }

    @Override
    public Purchase getPurchaseById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/purchase/" + id, Purchase.class);
    }

    @Override
    public Purchase savePurchase(Purchase purchase) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/purchase", purchase, Purchase.class).getBody();
    }

    @Override
    public void deletePurchase(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/purchase/" + id);
    }
}
