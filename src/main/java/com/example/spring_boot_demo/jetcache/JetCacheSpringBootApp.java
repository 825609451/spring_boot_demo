package com.example.spring_boot_demo.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
@EnableMethodCache(basePackages = "com.example.spring_boot_demo.jetcache")
@EnableCreateCacheAnnotation
public class JetCacheSpringBootApp {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        InputStream resourceAsStream = JetCacheSpringBootApp.class.getClassLoader().getResourceAsStream("jetcache.properties");
        properties.load(resourceAsStream);
        SpringApplication app=new SpringApplication(JetCacheSpringBootApp.class);
        app.setDefaultProperties(properties);
        app.run(args);
        //SpringApplication.run(JetCacheSpringBootApp.class);
    }
}