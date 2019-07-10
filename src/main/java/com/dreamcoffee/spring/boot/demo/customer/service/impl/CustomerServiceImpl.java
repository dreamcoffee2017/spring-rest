package com.dreamcoffee.spring.boot.demo.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcoffee.spring.boot.demo.customer.entity.Customer;
import com.dreamcoffee.spring.boot.demo.customer.mapper.CustomerMapper;
import com.dreamcoffee.spring.boot.demo.customer.service.ICustomerService;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerDTO;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public List<CustomerDTO> listCustomer(CustomerParam param) {
        List<CustomerDTO> result = new ArrayList<>();
        this.list(new QueryWrapper<Customer>().lambda()
                .eq(Customer::getName, param.getName()))
                .forEach(o -> {
                    CustomerDTO customerDTO = new CustomerDTO();
                    BeanUtils.copyProperties(o, customerDTO);
                    result.add(customerDTO);
                });
        return result;
    }

    @Override
    @Transactional
    public void saveCustomer(CustomerParam param) {
        param.getNameList().forEach(name -> {
            Customer customer = new Customer();
            customer.setName(name);
            this.baseMapper.insert(customer);
        });
    }
}
