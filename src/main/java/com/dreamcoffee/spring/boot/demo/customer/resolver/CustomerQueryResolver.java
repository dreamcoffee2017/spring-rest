package com.dreamcoffee.spring.boot.demo.customer.resolver;

import com.dreamcoffee.spring.boot.demo.customer.dto.CustomerDto;
import com.dreamcoffee.spring.boot.demo.customer.service.ICustomerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class CustomerQueryResolver implements GraphQLQueryResolver {

    private final ICustomerService customerService;

    public CustomerQueryResolver(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public List<CustomerDto> listCustomer(@NotBlank String name) {
        return customerService.listCustomer(name);
    }
}
