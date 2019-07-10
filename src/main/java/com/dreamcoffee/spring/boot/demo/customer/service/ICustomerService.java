package com.dreamcoffee.spring.boot.demo.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dreamcoffee.spring.boot.demo.customer.entity.Customer;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerDTO;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerParam;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-06
 */
public interface ICustomerService extends IService<Customer> {

    /**
     * listCustomer
     *
     * @param param
     * @return
     */
    List<CustomerDTO> listCustomer(CustomerParam param);

    /**
     * saveCustomer
     *
     * @param param
     */
    void saveCustomer(CustomerParam param);
}
