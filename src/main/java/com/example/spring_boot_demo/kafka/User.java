package com.example.spring_boot_demo.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName : User
 * @Description : 用户消息类
 * @Author : sky
 * @Date: 2020-05-05 04:05
 */
@Data
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private int id;
    private String userName;
}
