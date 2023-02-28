package com.example.springrest.customer.controller;

import com.example.springrest.customer.dto.CustomerDto;
import com.example.springrest.customer.input.CustomerInput;
import com.example.springrest.customer.service.ICustomerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("customer")
@Validated
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("list")
    public List<CustomerDto> listCustomer(@NotBlank String name) {
        return customerService.listCustomer(name);
    }

    @PostMapping("create")
    public void createCustomer(@RequestBody @Valid CustomerInput input) {
        customerService.saveCustomer(input);
    }
}
