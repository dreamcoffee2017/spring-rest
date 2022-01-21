package com.dreamcoffee.spring.boot.demo.config;

import javax.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handler(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
