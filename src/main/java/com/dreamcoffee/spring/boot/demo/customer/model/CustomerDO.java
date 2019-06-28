package com.dreamcoffee.spring.boot.demo.customer.model;

import com.alibaba.fastjson.JSON;

/**
 * CustomerDO
 *
 * @author Administrator
 * @date 2019/6/18
 */
public class CustomerDO {

    private String name;

    private Integer number;

    public CustomerDO(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
