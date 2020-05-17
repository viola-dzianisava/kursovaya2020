package com.gym.backend.repository;

import com.gym.backend.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<PurchaseEntity, Integer> {
}
