package com.gym.fapi.controller;

import com.gym.fapi.models.Faq;
import com.gym.fapi.models.News;
import com.gym.fapi.service.FaqService;
import com.gym.fapi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faq")
public class FaqController {


    @Autowired
    private FaqService faqService;

    @RequestMapping
    public ResponseEntity<List<Faq>> getAllFaq() {
        return ResponseEntity.ok(faqService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Faq> saveCategory(@RequestBody Faq faq /*todo server validation*/) {
        if (faq != null) {
            return ResponseEntity.ok(faqService.saveFaq(faq));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFaq(@PathVariable String id) {
        faqService.deleteFaq(Integer.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Faq> getAllFaq(@PathVariable String id) throws InterruptedException {
        int faqId = Integer.valueOf(id);
        return ResponseEntity.ok(faqService.getFaqById(faqId));
    }
}
