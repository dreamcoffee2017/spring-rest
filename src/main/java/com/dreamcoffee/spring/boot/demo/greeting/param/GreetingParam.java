package com.dreamcoffee.spring.boot.demo.greeting.param;

import com.alibaba.fastjson.JSON;

/**
 * GreetingParam
 *
 * @author Administrator
 * @date 2019/6/18
 */
public class GreetingParam {

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
