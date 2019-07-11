package com.dreamcoffee.spring.boot.demo.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcoffee.spring.boot.demo.customer.cache.CustomerCache;
import com.dreamcoffee.spring.boot.demo.customer.entity.Customer;
import com.dreamcoffee.spring.boot.demo.customer.mapper.CustomerMapper;
import com.dreamcoffee.spring.boot.demo.customer.service.ICustomerService;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerDTO;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerParam;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Autowired
    private CustomerCache customerCache;

    @Override
    public List<CustomerDTO> listCustomer(CustomerParam param) {
        return customerCache.listCustomer(param);
    }

    @Override
    @Transactional
    public void saveCustomer(CustomerParam param) {
        customerCache.saveCustomer(param);
    }
}
