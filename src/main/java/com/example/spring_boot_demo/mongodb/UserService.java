package com.example.spring_boot_demo.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @ClassName : UserService
 * @Description :
 * @Author : sky
 * @Date: 2020-05-10 21:28
 */
//@Service
public class UserService {
    //@Autowired(required = false)
    private IMongoDbUserDao userDao;

   // @Autowired
    private MongoTemplate mongoTemplate;

    public User save(User u){
        return userDao.save(u);
    }
    public void delete(Integer id){
        userDao.deleteById(id);
    }
    public void update (User u){
        Assert.notNull(u.getId(),"id is not null");
        userDao.save(u);
    }
    public User getById(Integer id){
        return userDao.findById(id).get();
    }
    public Page<User> findList(){
        PageRequest request =PageRequest.of(10,1);
        return userDao.findAll(request);
    }

 }
