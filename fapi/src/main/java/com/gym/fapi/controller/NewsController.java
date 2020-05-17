package com.gym.fapi.controller;

import com.gym.fapi.models.News;
import com.gym.fapi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {


    @Autowired
    private NewsService newsService;

    @RequestMapping
    public ResponseEntity<List<News>> getAllNews() {
        return ResponseEntity.ok(newsService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<News> saveNews(@RequestBody News news /*todo server validation*/) {
        if (news != null) {
            return ResponseEntity.ok(newsService.saveNews(news));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteNews(@PathVariable String id) {
        newsService.deleteNews(Integer.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<News> getAllNews(@PathVariable String id) throws InterruptedException {
        int newsId = Integer.valueOf(id);
        return ResponseEntity.ok(newsService.getNewsById(newsId));
    }
}
