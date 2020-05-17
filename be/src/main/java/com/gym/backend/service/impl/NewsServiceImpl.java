package com.gym.backend.service.impl;

import com.gym.backend.entity.NewsEntity;
import com.gym.backend.repository.NewsRepository;
import com.gym.backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NewsServiceImpl implements NewsService {

    private NewsRepository repository;

    @Autowired
    public NewsServiceImpl(NewsRepository repository) {
        this.repository = repository;
    }

    @Override
    public NewsEntity saveNews(NewsEntity newsEntity) {
        return repository.save(newsEntity);
    }

    @Override
    public Optional<NewsEntity> getNewsById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<NewsEntity> getAllNews() {
        return repository.findAll();
    }

    @Override
    public void deleteNews(Integer id) {
        repository.deleteById(id);
    }
}
