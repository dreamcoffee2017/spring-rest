package com.dreamcoffee.spring.boot.demo.customer.service;

import com.dreamcoffee.spring.boot.demo.customer.model.CustomerDO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * CustomerService
 *
 * @author Administrator
 * @date 2019/6/27
 */
@Service
public class CustomerService {

    public List<CustomerDO> listCustomer() throws Exception {
        if(1==1){
            throw new Exception("a");
        }
        return Arrays.asList(new CustomerDO("张三", 1),
                new CustomerDO("李四", 2));
    }
}
