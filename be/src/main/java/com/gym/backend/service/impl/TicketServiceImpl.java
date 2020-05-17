package com.gym.backend.service.impl;

import com.gym.backend.entity.TicketEntity;
import com.gym.backend.repository.TicketRepository;
import com.gym.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TicketServiceImpl implements TicketService {

    private TicketRepository repository;

    @Autowired
    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public TicketEntity saveTicket(TicketEntity ticketEntity) {
        return repository.save(ticketEntity);
    }

    @Override
    public Optional<TicketEntity> getTicketById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<TicketEntity> getAllTicket() {
        return repository.findAll();
    }

    @Override
    public void deleteTicket(Integer id) {
        repository.deleteById(id);
    }
}
