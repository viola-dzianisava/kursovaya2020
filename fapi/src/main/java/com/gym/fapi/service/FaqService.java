package com.gym.fapi.service;

import com.gym.fapi.models.Faq;


import java.util.List;

public interface FaqService {
    List<Faq> getAll();

    Faq getFaqById(Integer id);

    Faq saveFaq(Faq faq);

    void deleteFaq(Integer id);
}
