package com.dreamcoffee.spring.boot.demo.common;

import com.alibaba.fastjson.JSON;

/**
 * ResultDTO
 *
 * @author Administrator
 * @date 2019/6/27
 */
public class ResultDTO<T> {

    private Integer code;

    private T data;

    public ResultDTO() {
    }

    public ResultDTO(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
