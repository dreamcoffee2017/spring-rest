package com.dreamcoffee.spring.boot.demo.customer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author Administrator
 * @since 2019-07-06
 */
@Data
@TableName("CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("NAME")
    private String name;

    @TableField("NUMBER")
    private BigDecimal number;
}
