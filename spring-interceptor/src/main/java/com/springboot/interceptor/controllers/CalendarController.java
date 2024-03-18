package com.springboot.interceptor.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class CalendarController {

    @GetMapping("/foo")
    public ResponseEntity<?> foo(HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("title", "Bienvenidos");
        data.put("time", LocalDateTime.now());
        data.put("message", request.getAttribute("message"));

        return ResponseEntity.ok(data);
    }
}
