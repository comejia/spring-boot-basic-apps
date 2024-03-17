package com.spring.error.controllers;

import com.spring.error.exceptions.UserNotFoundException;
import com.spring.error.models.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorDto> divisionByZero(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setDate(LocalDate.now());
        errorDto.setError("Error division by zero");
        errorDto.setMessage(e.getMessage());
        errorDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.internalServerError().body(errorDto);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDto> notFoundEx(NoHandlerFoundException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setDate(LocalDate.now());
        errorDto.setError("Api rest no encontrado");
        errorDto.setMessage(e.getMessage());
        errorDto.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler(NumberFormatException.class)
   // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> numberFormatException(Exception e) {
        //Map<String, Object> error = new HashMap<>();
        //error.put("date", LocalDate.now());
        //error.put("error", "Numero invalido o incorrecto");
        //error.put("message", e.getMessage());
        //error.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        //return error;

        ErrorDto errorDto = new ErrorDto();
        errorDto.setDate(LocalDate.now());
        errorDto.setError("Numero invalido o incorrecto");
        errorDto.setMessage(e.getMessage());
        errorDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> userNotFound(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setDate(LocalDate.now());
        errorDto.setError("El usuario o role no existe");
        errorDto.setMessage(e.getMessage());
        errorDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }
}
