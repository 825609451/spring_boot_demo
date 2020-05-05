package com.example.spring_boot_demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @KafkaListener(topics = "userTopic",groupId = "group1")
    public void onMessage(User user){
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println(user);
    }
}