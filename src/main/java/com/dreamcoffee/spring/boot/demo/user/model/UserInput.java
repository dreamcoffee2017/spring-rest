package com.dreamcoffee.spring.boot.demo.user.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserInput {

    @NotBlank
    private String name;
    @Email
    private String email;
}
