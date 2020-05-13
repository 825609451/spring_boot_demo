package com.example.spring_boot_demo.策略模式;

/**
 * @ClassName : TestMain
 * @Description :
 * @Author : sky
 * @Date: 2020-05-13 19:01
 */
public class TestMain {

    public static void main(String[] args) {
        OrderDto dto=new OrderDto();
        dto.setOrderType(2);
        OrderTypeHandlerEnum.getNByType(dto.getOrderType()).orderHadler(dto);
    }
}
