package com.dreamcoffee.spring.boot.demo.customer.vo;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * CustomerParam
 *
 * @author Administrator
 * @date 2019/6/18
 */
public class CustomerParam {

    private String name;

    private List<String> nameList;

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

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}
