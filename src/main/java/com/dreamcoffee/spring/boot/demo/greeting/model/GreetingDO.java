package com.dreamcoffee.spring.boot.demo.greeting.model;

import com.alibaba.fastjson.JSON;

/**
 * GreetingDO
 *
 * @author Administrator
 * @date 2019/6/18
 */
public class GreetingDO {

    private String name;

    private Integer number;

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
