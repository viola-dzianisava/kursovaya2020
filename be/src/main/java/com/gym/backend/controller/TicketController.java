package com.gym.backend.controller;



import com.gym.backend.entity.TicketEntity;
import com.gym.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TicketEntity> getTicketById(@PathVariable(name = "id") Integer id) {
        Optional<TicketEntity> ticketEntity = ticketService.getTicketById(id);
        if (ticketEntity.isPresent()) {
            return ResponseEntity.ok(ticketEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<TicketEntity> getAllTicket() {
        return ticketService.getAllTicket();
    }

    @RequestMapping(method = RequestMethod.POST)
    public TicketEntity saveTicket(@RequestBody TicketEntity ticketEntity) {
        return ticketService.saveTicket(ticketEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable(name = "id") Integer id) {
        ticketService.deleteTicket(id);
    }
}
