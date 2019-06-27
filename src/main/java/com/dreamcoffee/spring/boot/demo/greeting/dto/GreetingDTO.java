package com.dreamcoffee.spring.boot.demo.greeting.dto;

import com.alibaba.fastjson.JSON;

/**
 * GreetingDTO
 *
 * @author Administrator
 * @date 2019/6/18
 */
public class GreetingDTO {

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
