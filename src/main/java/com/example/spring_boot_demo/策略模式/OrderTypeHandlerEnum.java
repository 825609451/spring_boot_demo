package com.example.spring_boot_demo.策略模式;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public enum OrderTypeHandlerEnum {

    ORDINARY_ORDER(1, "普通订单"){
        @Override
        public void orderHadler(OrderDto dto) {
              log.info("记录>>>"+this.getOrderName());
        }
    }, ASSEMBLE_ORDER(2, "拼团订单") {
        @Override
        public void orderHadler(OrderDto dto) {
            log.info("记录>>>"+this.getOrderName());
        }
    }, RESERVATION_ORDER(3, "预约订单") {
        @Override
        public void orderHadler(OrderDto dto) {
            log.info("记录>>>"+this.getOrderName());
        }
    };

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    private int type;
    private String orderName;



    OrderTypeHandlerEnum(int type, String orderName) {
        this.type = type;
        this.orderName = orderName;
    }

    /**
     * 根据type获取枚举实例
     * @param orderType
     * @return
     */
    public static OrderTypeHandlerEnum getNByType(int orderType) {
        for (OrderTypeHandlerEnum e : OrderTypeHandlerEnum.values()) {
            if (Objects.equals(e.getType(),orderType)) {
                return e;
            }
        }
        return null;
    }
    /**
     * @param dto  订单dto
     */
    public abstract void orderHadler(OrderDto dto);

}
