package com.example.spring_boot_demo.aop;

import com.example.spring_boot_demo.mongodb.IMongoDbUserDao;
import com.example.spring_boot_demo.mongodb.MongodbSpringBootApp;
import com.example.spring_boot_demo.mongodb.User;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName : MongodbTest
 * @Description : 测试类
 * @Author : sky
 * @Date: 2020-05-12 13:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={AopSpringBootApp.class})// 指定启动类
@DisplayName("aop测试类")
public class AopTest {
    @Autowired
    IAopUser user;
    @Test
    public void add(){
        user.saveuser(5);
    }
}
