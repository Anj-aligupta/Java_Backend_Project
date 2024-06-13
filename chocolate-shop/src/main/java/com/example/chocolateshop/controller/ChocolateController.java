package com.example.chocolateshop.controller;

import com.example.chocolateshop.model.Chocolate;
import com.example.chocolateshop.service.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChocolateController {
    @Autowired
    private ChocolateService chocolateService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Chocolate> chocolates = chocolateService.getAllChocolates();
        model.addAttribute("chocolates", chocolates);
        return "index";
    }

    @GetMapping("/showNewChocolateForm")
    public String showNewChocolateForm(Model model) {
        Chocolate chocolate = new Chocolate();
        model.addAttribute("chocolate", chocolate);
        return "new_chocolate";
    }

    @PostMapping("/saveChocolate")
    public String saveChocolate(@ModelAttribute("chocolate") Chocolate chocolate) {
        chocolateService.saveChocolate(chocolate);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Chocolate chocolate = chocolateService.getChocolateById(id);
        model.addAttribute("chocolate", chocolate);
        return "update_chocolate";
    }

    @GetMapping("/deleteChocolate/{id}")
    public String deleteChocolate(@PathVariable(value = "id") long id) {
        this.chocolateService.deleteChocolate(id);
        return "redirect:/";
    }
}

