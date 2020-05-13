package com.example.spring_boot_demo.mongodb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
@SpringBootTest(classes={MongodbSpringBootApp.class})// 指定启动类
@DisplayName("mongodb测试类")
public class MongodbTest {
    @Autowired
    IMongoDbUserDao userDao;
    @Test
    public void add(){
        userDao.save(new User(1,"SKY","13342813451","测试用户",new GeoJsonPoint(113.835001,22.728618)));
    }
}
