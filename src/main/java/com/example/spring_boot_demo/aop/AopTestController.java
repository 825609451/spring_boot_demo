package com.example.spring_boot_demo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : AopTestController
 * @Description :
 * @Author : sky
 * @Date: 2020-05-12 23:02
 */
@RestController
@RequestMapping("/aop")
public class AopTestController {
    @Autowired
    IAopUser aopUser;

    @GetMapping("/user")
    public String save(){
        aopUser.saveuser(10);
        return  "ok";
    }
}
