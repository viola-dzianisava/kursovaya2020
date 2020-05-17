package com.gym.fapi.controller;

import com.gym.fapi.models.Purchase;
import com.gym.fapi.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping
    public ResponseEntity<List<Purchase>> getAllPurchase() {
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase purchase /*todo server validation*/) {
        if (purchase != null) {
            return ResponseEntity.ok(purchaseService.savePurchase(purchase));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePurchase(@PathVariable String id) {
        purchaseService.deletePurchase(Integer.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Purchase> getAllPurchase(@PathVariable String id) throws InterruptedException {
        int purchaseId = Integer.valueOf(id);
        return ResponseEntity.ok(purchaseService.getPurchaseById(purchaseId));
    }
}
