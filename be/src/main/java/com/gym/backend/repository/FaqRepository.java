package com.gym.backend.repository;

import com.gym.backend.entity.FaqEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends CrudRepository<FaqEntity, Integer> {
}
