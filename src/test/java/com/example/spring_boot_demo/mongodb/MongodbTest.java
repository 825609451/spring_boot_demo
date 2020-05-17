package com.example.spring_boot_demo.mongodb;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName : MongodbTest
 * @Description : 测试类
 * @Author : sky
 * @Date: 2020-05-12 13:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={MongodbSpringBootApp.class})// 指定启动类
public class MongodbTest {
    @Autowired
    IMongoDbUserDao userDao;
    @Autowired
    UserService userService;
    @Test
    public void add(){
        for(int i=2;i<11;i++){
            userDao.save(new User(i,"SKY"+i,"13342813451","测试用户"+i,new GeoJsonPoint(111.835001+i,23.728618-i)));
        }
        System.out.println("ok");
    }

    @Test
    public void getNearLocation(){
        userService.getNearLocation(22.728618,113.835001);
    }


    @Test
    public void getCircleLocation(){
        List<User> circleLocation = userService.getCircleLocation(22.728618,113.835001, 1000);
        System.out.println(circleLocation);
    }
}
