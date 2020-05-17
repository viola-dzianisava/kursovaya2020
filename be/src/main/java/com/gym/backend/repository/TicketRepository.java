package com.gym.backend.repository;

import com.gym.backend.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {
}
