package com.dreamcoffee.spring.boot.demo.customer.service;

import com.dreamcoffee.spring.boot.demo.customer.dto.CustomerDto;
import com.dreamcoffee.spring.boot.demo.customer.input.CustomerInput;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-06
 */
public interface ICustomerService {

    /**
     * listCustomer
     *
     * @param name
     * @return
     */
    List<CustomerDto> listCustomer(String name);

    /**
     * saveCustomer
     *
     * @param input
     */
    void saveCustomer(CustomerInput input);
}
