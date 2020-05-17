package com.gym.backend.service;

        import com.gym.backend.entity.NewsEntity;

        import java.util.Optional;

public interface NewsService {

    NewsEntity saveNews(NewsEntity newsEntity);

    Optional<NewsEntity> getNewsById(Integer id);

    Iterable<NewsEntity> getAllNews();

    void deleteNews(Integer id);
}