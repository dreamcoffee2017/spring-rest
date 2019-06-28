package com.dreamcoffee.spring.boot.demo.customer.controller;

import com.dreamcoffee.spring.boot.demo.common.ResultDTO;
import com.dreamcoffee.spring.boot.demo.common.ResultEnum;
import com.dreamcoffee.spring.boot.demo.customer.model.CustomerDO;
import com.dreamcoffee.spring.boot.demo.customer.service.CustomerService;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CustomerController
 *
 * @author Administrator
 * @date 2019/5/27
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @RequestMapping("/listCustomer")
    public ResultDTO listCustomer(@RequestBody CustomerParam param, CustomerService customerService) throws Exception {
        ResultDTO<List<CustomerDO>> result = new ResultDTO<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setData(customerService.listCustomer());
        return result;
    }
}
