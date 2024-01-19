package com.comejia.spring.web.controllers;

import com.comejia.spring.web.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "No message sent") String message) {
        ParamDto paramDto = new ParamDto(message);

        return paramDto;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam(required = false, defaultValue = "No message sent") String text, @RequestParam Integer code) {
        ParamDto paramDto = new ParamDto(text, code);

        return paramDto;
    }

    @GetMapping("/request")
    public ParamDto request(HttpServletRequest httpRequest) {
        Integer code;

        try {
            code = Integer.valueOf(httpRequest.getParameter("code"));
        } catch (NumberFormatException e) {
            code = 0;
        }
        ParamDto paramDto = new ParamDto(httpRequest.getParameter("text"), code);

        return paramDto;
    }
}
