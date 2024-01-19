package com.comejia.spring.web.controllers;

import com.comejia.spring.web.models.User;
import com.comejia.spring.web.models.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details() {
        User user = new User("Curso", "Udemy");
        UserDto userDto = new UserDto("Hola mundo Spring boot", user);

        return userDto;
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {
        Map<String, Object> body = new HashMap<>();

        User user = new User("Curso", "Udemy");

        body.put("title", "Hola mundo Spring boot");
        body.put("user", user);

        return body;
    }

    @GetMapping("/users")
    public List<User> list() {
        User curso = new User("Curso", "Udemy");
        User pepe = new User("Pepe", "Doe");
        User jhon = new User("Jhon", "Doe");

        List<User> users = Arrays.asList(curso, pepe, jhon);

        return users;
    }
}
