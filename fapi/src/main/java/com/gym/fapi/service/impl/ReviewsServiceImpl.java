package com.gym.fapi.service.impl;

import com.gym.fapi.models.Reviews;
import com.gym.fapi.service.ReviewsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ReviewsServiceImpl implements ReviewsService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Reviews> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Reviews[] reviewsResponse = restTemplate.getForObject(backendServerUrl + "/api/reviews/", Reviews[].class);
        return reviewsResponse == null ? Collections.emptyList() : Arrays.asList(reviewsResponse);
    }

    @Override
    public Reviews getReviewsById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/reviews/" + id, Reviews.class);
    }

    @Override
    public Reviews saveReviews(Reviews reviews) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/reviews", reviews, Reviews.class).getBody();
    }

    @Override
    public void deleteReviews(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/reviews/" + id);
    }
}
