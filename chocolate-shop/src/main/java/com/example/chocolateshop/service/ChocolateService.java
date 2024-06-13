package com.example.chocolateshop.service;

import com.example.chocolateshop.model.Chocolate;
import com.example.chocolateshop.repository.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChocolateService {
    @Autowired
    private ChocolateRepository chocolateRepository;

    public List<Chocolate> getAllChocolates() {
        return chocolateRepository.findAll();
    }

    public void saveChocolate(Chocolate chocolate) {
        chocolateRepository.save(chocolate);
    }

    public Chocolate getChocolateById(Long id) {
        return chocolateRepository.findById(id).orElse(null);
    }

    public void deleteChocolate(Long id) {
        chocolateRepository.deleteById(id);
    }
}
