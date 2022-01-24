package com.dreamcoffee.spring.boot.demo.customer.service.impl;

import com.dreamcoffee.spring.boot.demo.customer.cache.CustomerCache;
import com.dreamcoffee.spring.boot.demo.customer.dto.CustomerDto;
import com.dreamcoffee.spring.boot.demo.customer.input.CustomerInput;
import com.dreamcoffee.spring.boot.demo.customer.service.ICustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private CustomerCache customerCache;

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
