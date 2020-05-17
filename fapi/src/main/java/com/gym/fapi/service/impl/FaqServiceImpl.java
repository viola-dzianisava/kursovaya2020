package com.gym.fapi.service.impl;

import com.gym.fapi.models.Faq;
import com.gym.fapi.service.FaqService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class FaqServiceImpl implements FaqService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Faq> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Faq[] newsResponse = restTemplate.getForObject(backendServerUrl + "/api/faq/", Faq[].class);
        return newsResponse == null ? Collections.emptyList() : Arrays.asList(newsResponse);
    }

    @Override
    public Faq getFaqById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/faq/" + id, Faq.class);
    }

    @Override
    public Faq saveFaq(Faq faq) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/faq", faq, Faq.class).getBody();
    }

    @Override
    public void deleteFaq(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/faq/" + id);
    }
}
