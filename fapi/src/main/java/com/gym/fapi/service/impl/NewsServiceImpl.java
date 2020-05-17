package com.gym.fapi.service.impl;

import com.gym.fapi.models.News;
import com.gym.fapi.service.NewsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class NewsServiceImpl implements NewsService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<News> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        News[] newsResponse = restTemplate.getForObject(backendServerUrl + "/api/news/", News[].class);
        return newsResponse == null ? Collections.emptyList() : Arrays.asList(newsResponse);
    }

    @Override
    public News getNewsById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/news/" + id, News.class);
    }

    @Override
    public News saveNews(News news) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/news", news, News.class).getBody();
    }

    @Override
    public void deleteNews(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/news/" + id);
    }
}
