package com.gym.backend.service;


import com.gym.backend.entity.TicketEntity;

import java.util.Optional;

public interface TicketService {

    TicketEntity saveTicket(TicketEntity reviewsEntity);

    Optional<TicketEntity> getTicketById(Integer id);

    Iterable<TicketEntity> getAllTicket();

    void deleteTicket(Integer id);
}