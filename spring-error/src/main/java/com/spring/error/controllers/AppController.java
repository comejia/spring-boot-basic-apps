package com.spring.error.controllers;

import com.spring.error.exceptions.UserNotFoundException;
import com.spring.error.models.domain.User;
import com.spring.error.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        int value = 100 / 0;
        return "ok 200";
    }

    @GetMapping("/otro")
    public String parser() {
        int value = Integer.parseInt("10x");
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id) {
        Optional<User> user = userService.findById(id);

        return user.orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
