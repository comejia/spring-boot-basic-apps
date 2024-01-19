package com.comejia.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Hola mundo Spring boot");
        model.addAttribute("name", "Curso");
        model.addAttribute("lastname", "Udemy");

        return "details";
    }
}
