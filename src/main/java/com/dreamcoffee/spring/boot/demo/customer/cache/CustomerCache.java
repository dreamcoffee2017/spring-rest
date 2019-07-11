package com.dreamcoffee.spring.boot.demo.customer.cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dreamcoffee.spring.boot.demo.customer.entity.Customer;
import com.dreamcoffee.spring.boot.demo.customer.mapper.CustomerMapper;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerDTO;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * CustomerCache
 * 默认proxy模式，不支持类内部调用
 * 根据查询条件缓存，缓存hot页
 *
 * @author Administrator
 * @date 2019/7/11
 */
@Component
@CacheConfig(cacheNames = "customer")
public class CustomerCache {

    @Autowired
    private CustomerMapper customerMapper;

    @Cacheable(key = "#param.name", sync = true)
    public List<CustomerDTO> listCustomer(CustomerParam param) {
        System.out.println("list and cache");
        List<CustomerDTO> result = new ArrayList<>();
        customerMapper.selectList(new QueryWrapper<Customer>().lambda()
                .eq(Customer::getName, param.getName())
        ).forEach(o -> {
            CustomerDTO customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(o, customerDTO);
            result.add(customerDTO);
        });
        return result;
    }

    @Transactional
    @CacheEvict(allEntries = true)
    public void saveCustomer(CustomerParam param) {
        System.out.println("save and evict all");
        Customer customer = new Customer();
        customer.setName(param.getName());
        customerMapper.insert(customer);
    }
}
