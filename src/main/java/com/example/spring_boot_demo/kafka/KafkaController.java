package com.example.spring_boot_demo.kafka;

import com.example.spring_boot_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @GetMapping("/kafka/sendMsg")
    public boolean saveUser(User user){
        kafkaTemplate.send("userTopic","hello");
        System.out.println(user);
        return true;
    }

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}