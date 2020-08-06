package com.dreamcoffee.spring.boot.demo.customer.controller;


import com.dreamcoffee.spring.boot.demo.common.ResultDTO;
import com.dreamcoffee.spring.boot.demo.common.ResultEnum;
import com.dreamcoffee.spring.boot.demo.customer.service.ICustomerService;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerDTO;
import com.dreamcoffee.spring.boot.demo.customer.vo.CustomerParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Administrator
 * @since 2019-07-06
 */
@RestController
@RequestMapping(value = "/customer", method = RequestMethod.POST)
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/listCustomer")
    public ResultDTO<List<CustomerDTO>> listCustomer(@RequestBody CustomerParam param) {
        ResultDTO<List<CustomerDTO>> result = new ResultDTO<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setData(customerService.listCustomer(param));
        return result;
    }

    @RequestMapping("/saveCustomer")
    public ResultDTO<List<CustomerDTO>> saveCustomer(@RequestBody CustomerParam param) {
        ResultDTO<List<CustomerDTO>> result = new ResultDTO<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        customerService.saveCustomer(param);
        return result;
    }
}

