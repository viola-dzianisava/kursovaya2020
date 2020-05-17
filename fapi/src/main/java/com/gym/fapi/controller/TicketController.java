package com.gym.fapi.controller;

import com.gym.fapi.models.Ticket;
import com.gym.fapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping
    public ResponseEntity<List<Ticket>> getAllReviews() {
        return ResponseEntity.ok(ticketService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket /*todo server validation*/) {
        if (ticket != null) {
            return ResponseEntity.ok(ticketService.saveTicket(ticket));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable String id) {
        ticketService.deleteTicket(Integer.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Ticket> getAllTicket(@PathVariable String id) throws InterruptedException {
        int ticketId = Integer.valueOf(id);
        return ResponseEntity.ok(ticketService.getTicketById(ticketId));
    }
}
