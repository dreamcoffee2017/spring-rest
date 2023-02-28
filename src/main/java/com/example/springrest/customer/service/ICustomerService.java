package com.example.springrest.customer.service;

import com.example.springrest.customer.dto.CustomerDto;
import com.example.springrest.customer.input.CustomerInput;

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
     * @param name customer's name
     * @return dto
     */
    List<CustomerDto> listCustomer(String name);

    /**
     * saveCustomer
     *
     * @param input param
     */
    void saveCustomer(CustomerInput input);
}
