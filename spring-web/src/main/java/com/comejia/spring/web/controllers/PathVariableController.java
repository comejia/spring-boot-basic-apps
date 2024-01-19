package com.comejia.spring.web.controllers;

import com.comejia.spring.web.models.User;
import com.comejia.spring.web.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.code}")
    private Integer code;
    @Value("${config.username}")
    private String username;

    @GetMapping("/foo/{message}")
    public ParamDto foo(@PathVariable() String message) {
        ParamDto paramDto = new ParamDto(message);

        return paramDto;
    }

    @GetMapping("/bar/{code}")
    public ParamDto bar(@PathVariable() Integer code) {
        ParamDto paramDto = new ParamDto("", code);

        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}")
    public ParamDto mix(@PathVariable String product, @PathVariable() Integer id) {
        ParamDto paramDto = new ParamDto(product, id);

        return paramDto;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setLastname(user.getLastname().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public ParamDto values() {
        ParamDto paramDto = new ParamDto(username, code);

        return paramDto;
    }
}
