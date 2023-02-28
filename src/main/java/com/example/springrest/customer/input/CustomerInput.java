package com.example.springrest.customer.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerInput {

    @NotBlank
    private String name;
    @Email
    private String email;
}
