package com.dreamcoffee.spring.boot.demo.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
        return ToStringBuilder.reflectionToString(this);
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
