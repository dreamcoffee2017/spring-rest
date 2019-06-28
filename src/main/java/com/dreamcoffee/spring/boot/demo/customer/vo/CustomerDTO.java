package com.dreamcoffee.spring.boot.demo.customer.vo;

import com.alibaba.fastjson.JSON;

/**
 * CustomerDTO
 *
 * @author Administrator
 * @date 2019/6/18
 */
public class CustomerDTO {

    private String name;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
