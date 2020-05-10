package com.example.spring_boot_demo.requestMerge;

import lombok.AllArgsConstructor;
import lombok.Generated;

/**
 * 简单参数封装
 * @ClassName : R
 * @Description :
 * @Author : sky
 * @Date: 2020-05-10 19:18
 */
@AllArgsConstructor
@Generated
public class R<T> {
    private int code;
    private T data;

    private R() {
    }

    public static <T> R<T> ok(T data) {
        R result = new R(200, data);
        return result;
    }

    public static <T> R<T> error() {
        R result = new R(500, null);
        return result;
    }

}
