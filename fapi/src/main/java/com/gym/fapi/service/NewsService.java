package com.gym.fapi.service;

import com.gym.fapi.models.News;

import java.util.List;

public interface NewsService {
    List<News> getAll();

    News getNewsById(Integer id);

    News saveNews(News news);

    void deleteNews(Integer id);
}
