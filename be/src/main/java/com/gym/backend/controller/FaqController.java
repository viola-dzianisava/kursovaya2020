package com.gym.backend.controller;

import com.gym.backend.entity.FaqEntity;
import com.gym.backend.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/faq")
public class FaqController {

    private FaqService faqService;

    @Autowired
    public FaqController(FaqService faqService) {
        this.faqService = faqService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FaqEntity> getFaqById(@PathVariable(name = "id") Integer id) {
        Optional<FaqEntity> faqEntity = faqService.getFaqById(id);
        if (faqEntity.isPresent()) {
            return ResponseEntity.ok(faqEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<FaqEntity> getAllFaq() {
        return faqService.getAllFaq();
    }

    @RequestMapping(method = RequestMethod.POST)
    public FaqEntity saveFaq(@RequestBody FaqEntity faq) {
        return faqService.saveFaq(faq);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFaq(@PathVariable(name = "id") Integer id) {
        faqService.deleteFaq(id);
    }
}
