package com.gym.fapi.service;

import com.gym.fapi.models.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAll();

    Ticket getTicketById(Integer id);

    Ticket saveTicket(Ticket ticket);

    void deleteTicket(Integer id);
}
