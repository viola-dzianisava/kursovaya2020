package com.gym.fapi.service.impl;

import com.gym.fapi.models.Ticket;
import com.gym.fapi.service.TicketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class TicketServiceImpl implements TicketService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Ticket> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Ticket[] reviewsResponse = restTemplate.getForObject(backendServerUrl + "/api/ticket/", Ticket[].class);
        return reviewsResponse == null ? Collections.emptyList() : Arrays.asList(reviewsResponse);
    }

    @Override
    public Ticket getTicketById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/ticket/" + id, Ticket.class);
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/ticket", ticket, Ticket.class).getBody();
    }

    @Override
    public void deleteTicket(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/ticket/" + id);
    }
}
