package com.example.spring_boot_demo.requestMerge;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MergeSpringBootApp {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(MergeSpringBootApp.class, args);
    }
}