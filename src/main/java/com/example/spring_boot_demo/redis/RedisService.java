package com.example.spring_boot_demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

/**
 * @ClassName : RedisService
 * @Description :
 * @Author : sky
 * @Date: 2020-05-15 23:27
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    private  String H_KEY="test_hash:";

    public void save1000(){
        for (int i = 0; i <1000 ; i++) {
            //redisTemplate.opsForHash().put(H_KEY,"");
        }

    }
}
