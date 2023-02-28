package com.example.springrest.customer.cache;

import com.example.springrest.customer.dao.ICustomerDao;
import com.example.springrest.customer.dto.CustomerDto;
import com.example.springrest.customer.entity.Customer;
import com.example.springrest.customer.input.CustomerInput;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * CustomerCache 默认proxy模式，不支持类内部调用 根据查询条件缓存，缓存hot页
 *
 * @author Administrator
 * @since 2019/7/11
 */
@Component
@CacheConfig(cacheNames = "customer")
public class CustomerCache {
    private final ICustomerDao customerDao;

    public CustomerCache(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Cacheable(key = "#name", sync = true)
    public List<CustomerDto> listCustomer(String name) {
        System.out.println("list and cache");
        List<CustomerDto> result = new ArrayList<>();
        customerDao.findByName(name).forEach(o -> {
            CustomerDto customerDTO = new CustomerDto();
            BeanUtils.copyProperties(o, customerDTO);
            result.add(customerDTO);
        });
        return result;
    }

    @Transactional
    @CacheEvict(allEntries = true)
    public void saveCustomer(CustomerInput input) {
        System.out.println("save and evict all");
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString().replace("-", ""));
        customer.setName(input.getName());
        customer.setEmail(input.getEmail());
        customerDao.insert(customer);
    }
}
