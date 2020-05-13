package com.example.spring_boot_demo.mongodb;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.example.spring_boot_demo.jetcache.JetCacheSpringBootApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class MongodbSpringBootApp {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(MongodbSpringBootApp.class,args);
    }
}