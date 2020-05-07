package com.example.spring_boot_demo.nacos;

import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName : ConfigData
 * @Description : 获取通用配置信息入口
 * @Author : sky
 * @Date: 2020-05-07 16:24
 */
@Component
public class GlobalConfig {

   static  NacosConfigData config;

   @Autowired
   private NacosConfigData nacosConfig;

   @PostConstruct
   public void initConfig(){
       this.config=nacosConfig;
   }

    public static String getAppName() {
        return config.getAppName();
    }

    public static boolean isIsStart() {
        return config.isIsStart();
    }

    public static int getAppNum() {
        return config.getAppNum();
    }
}
