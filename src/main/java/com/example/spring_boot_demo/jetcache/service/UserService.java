package com.example.spring_boot_demo.jetcache.service;

import com.example.spring_boot_demo.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

/**
 * @ClassName : UserService
 * @Description : 用户service
 * @Author : sky
 * @Date: 2020-05-06 23:28
 */
@Service
public class UserService implements IuserService {
    //简单模拟数据库，这里不考虑并发
    private List<User> dbUsers=new ArrayList<>();

    UserService(){
        dbUsers.add(new User(1,"SKY",26));
    }
    @Override
    public void save(User u) {
        System.out.println("save:" + u);
        dbUsers.add(u);
    }

    @Override
    public void delete(int userId) {
        System.out.println("delete :" + userId);
        Iterator<User> iterator = dbUsers.iterator();
        while (iterator.hasNext()){
            if(Objects.equals(iterator.next().getId(),userId) ){
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void update(User u) {
        System.out.println("update :" + u);
        for(User  dbu:dbUsers){
            if(Objects.equals(dbu.getId(),u.getId())){
                dbu.setAge(u.getAge());
                dbu.setUserName(u.getUserName());
                System.out.println(dbUsers);
                return;
            }
        }
        //如果不需要更新则应该抛出异常让jetche 不执行
        throw  new RuntimeException("id is not null");
    }

    @Override
    public User getById(int userId) {
        System.out.println("select db ...");
        Optional<User> first = dbUsers.stream().filter(u -> Objects.equals(u.getId(), userId)).findFirst();
         return first.orElse(null);
    }

}


