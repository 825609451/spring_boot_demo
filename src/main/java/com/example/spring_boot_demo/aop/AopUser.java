package com.example.spring_boot_demo.aop;

import org.springframework.stereotype.Service;

/**
 * @ClassName : AopUser
 * @Description :
 * @Author : sky
 * @Date: 2020-05-12 22:35
 */
@Service
public class AopUser  implements  IAopUser{

    @Log("#id")
    public  void saveuser(int id){
        System.out.println("保存用戶》》》》"+id);
    }
}
