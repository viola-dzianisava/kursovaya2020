package com.gym.backend.controller;

import com.gym.backend.entity.NewsEntity;
import com.gym.backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<NewsEntity> getNewsById(@PathVariable(name = "id") Integer id) {
        Optional<NewsEntity> newsEntity = newsService.getNewsById(id);
        if (newsEntity.isPresent()) {
            return ResponseEntity.ok(newsEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<NewsEntity> getAllNews() {
        return newsService.getAllNews();
    }

    @RequestMapping(method = RequestMethod.POST)
    public NewsEntity saveNews(@RequestBody NewsEntity news) {
        return newsService.saveNews(news);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteNews(@PathVariable(name = "id") Integer id) {
        newsService.deleteNews(id);
    }
}
