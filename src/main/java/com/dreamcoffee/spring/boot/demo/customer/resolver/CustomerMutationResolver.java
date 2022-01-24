package com.dreamcoffee.spring.boot.demo.customer.resolver;

import com.dreamcoffee.spring.boot.demo.customer.input.CustomerInput;
import com.dreamcoffee.spring.boot.demo.customer.service.ICustomerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.validation.Valid;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class CustomerMutationResolver implements GraphQLMutationResolver {

    private final ICustomerService customerService;

    public CustomerMutationResolver(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public void createCustomer(@Valid CustomerInput input) throws Exception {
        customerService.saveCustomer(input);
    }
}
