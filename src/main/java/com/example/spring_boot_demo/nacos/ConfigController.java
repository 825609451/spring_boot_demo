package com.example.spring_boot_demo.nacos;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
public class ConfigController {
    @GetMapping(value = "config/get")
    public  String getConfig() {
        System.out.println("appName:"+GlobalConfig.getAppName());
        System.out.println("appNum:"+GlobalConfig.getAppNum());
        System.out.println("isStart:"+GlobalConfig.isIsStart());
        return "appName:"+GlobalConfig.getAppName()+"--appNum:"+GlobalConfig.getAppNum()+"--isStart:"+GlobalConfig.isIsStart() ;
    }
}