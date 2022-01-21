package com.dreamcoffee.spring.boot.demo.user.controller;

import com.dreamcoffee.spring.boot.demo.user.model.UserInput;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {

    @GetMapping("/getUser")
    ResponseEntity<String> getUser(@NotBlank String id) {
        return ResponseEntity.ok("valid");
    }

    @PostMapping("/createUser")
    ResponseEntity<String> createUser(@Valid @RequestBody UserInput input) {
        return ResponseEntity.ok("valid");
    }
}
