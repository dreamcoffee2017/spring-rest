package com.example.springrest.customer.service.impl;

import com.example.springrest.customer.cache.CustomerCache;
import com.example.springrest.customer.dto.CustomerDto;
import com.example.springrest.customer.input.CustomerInput;
import com.example.springrest.customer.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-06
 */
@Service
public class CustomerServiceImpl implements ICustomerService {
    private final CustomerCache customerCache;

    public CustomerServiceImpl(CustomerCache customerCache) {
        this.customerCache = customerCache;
    }

    @Override
    public List<CustomerDto> listCustomer(String name) {
        return customerCache.listCustomer(name);
    }

    @Override
    @Transactional
    public void saveCustomer(CustomerInput input) {
        customerCache.saveCustomer(input);
    }
}
