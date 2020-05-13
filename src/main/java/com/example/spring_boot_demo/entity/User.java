package com.example.spring_boot_demo.entity;

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
    private Integer id;
    private String userName;
    private Integer age;
}
