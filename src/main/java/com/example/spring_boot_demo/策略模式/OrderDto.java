package com.example.spring_boot_demo.策略模式;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName : OrderDto
 * @Description :
 * @Author : sky
 * @Date: 2020-05-13 18:51
 */
@Data
public class OrderDto {
    private String id;
    private BigDecimal amount;
    private  Integer orderType;
    //商品list 等等
}
