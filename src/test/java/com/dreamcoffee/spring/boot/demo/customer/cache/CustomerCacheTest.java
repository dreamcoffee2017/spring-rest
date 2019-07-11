package com.dreamcoffee.spring.boot.demo.customer.cache;

import com.dreamcoffee.spring.boot.demo.Application;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerParam;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

/**
 * CustomerCacheTest
 *
 * @author Administrator
 * @date 2019/7/11
 */
public class CustomerCacheTest {

    private CustomerCache customerCache;

    @Before
    public void setUp() {
        ApplicationContext ctx = SpringApplication.run(Application.class);
        customerCache = ctx.getBean(CustomerCache.class);
    }

    @Test
    public void testCache() {
        CustomerParam param = new CustomerParam();
        param.setName("s1");
        System.out.println(customerCache.listCustomer(param));
        System.out.println(customerCache.listCustomer(param));

        param.setName("s2");
        customerCache.saveCustomer(param);

        param.setName("s1");
        System.out.println(customerCache.listCustomer(param));
    }
}