package com.example.spring_boot_demo.aop;

import com.example.spring_boot_demo.jetcache.JetCacheSpringBootApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class AopSpringBootApp {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        InputStream resourceAsStream = AopSpringBootApp.class.getClassLoader().getResourceAsStream("aop.properties");
        properties.load(resourceAsStream);
        SpringApplication app=new SpringApplication(AopSpringBootApp.class);
        app.setDefaultProperties(properties);
        app.run(args);
    }
}