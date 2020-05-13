package com.example.spring_boot_demo.java8.builder;

import lombok.Data;

/**
 * @ClassName : UserBuilder
 * @Description :
 * @Author : sky
 * @Date: 2020-05-12 15:42
 */
@Data
public class UserBuilder {
    private int id;
    private String name;
    private int age;

    public static void main(String[] args) {
        UserBuilder user = Builder.of(UserBuilder::new).with(UserBuilder::setAge, 19).with(UserBuilder::setId, 1).with(UserBuilder::setName, "sky").build();
        System.out.println(user);

    }
}
