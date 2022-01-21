package com.dreamcoffee.spring.boot.demo.common;

import lombok.Data;

/**
 * ResultDTO
 *
 * @author Administrator
 * @date 2019/6/27
 */
@Data
public class ResultDTO<T> {

    private Integer code;

    private T data;

    public ResultDTO() {
    }

    public ResultDTO(Integer code) {
        this.code = code;
    }
}
