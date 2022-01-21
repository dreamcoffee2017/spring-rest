package com.dreamcoffee.spring.boot.demo.common;

/**
 * ResultEnum
 *
 * @author Administrator
 * @date 2019/6/27
 */
public enum ResultEnum {

    /**
     * 返回结果枚举
     */
    SUCCESS(1),
    FAIL(0);

    private final int code;

    ResultEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
