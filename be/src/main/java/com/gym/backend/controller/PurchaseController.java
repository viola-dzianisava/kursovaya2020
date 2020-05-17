package com.gym.backend.controller;

import com.gym.backend.entity.PurchaseEntity;
import com.gym.backend.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PurchaseEntity> getPurchaseById(@PathVariable(name = "id") Integer id) {
        Optional<PurchaseEntity> purchaseEntity = purchaseService.getPurchaseById(id);
        if (purchaseEntity.isPresent()) {
            return ResponseEntity.ok(purchaseEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<PurchaseEntity> getAllPurchase() {
        return purchaseService.getAllPurchase();
    }

    @RequestMapping(method = RequestMethod.POST)
    public PurchaseEntity savePurchase(@RequestBody PurchaseEntity purchase) {
        return purchaseService.savePurchase(purchase);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePurchase(@PathVariable(name = "id") Integer id) {
        purchaseService.deletePurchase(id);
    }
}
