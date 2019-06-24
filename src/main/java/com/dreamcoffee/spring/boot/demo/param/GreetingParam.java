package com.dreamcoffee.spring.boot.demo.param;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * GreetingParam
 *
 * @author Administrator
 * @date 2019/6/18
 */
public class GreetingParam {

    private Integer number;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
