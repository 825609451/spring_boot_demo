package com.example.spring_boot_demo.jetcache.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.example.spring_boot_demo.entity.User;
import com.example.spring_boot_demo.jetcache.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : UserController
 * @Description : 用戶控制类
 * @Author : sky
 * @Date: 2020-05-06 23:47
 */
@RestController
public class UserController {
    @Autowired
    private IuserService userService;

    @CreateCache(name = "userCache:",expire = 100, cacheType = CacheType.REMOTE, localLimit = 50)
    private Cache<Integer, User> userCache;

    @GetMapping("/user/getBuyId/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }
    @GetMapping("/user/update")
    public User update(User u){
        userService.update(u);
        return  userService.getById(u.getId());
    }
    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable int id){
        userService.delete(id);
        return "ok";
    }

    /**
     * 这里演示手动调用接口
     * @param id
     * @return
     */
    @GetMapping("/user/getByCacheId/{id}")
    public User getById2(@PathVariable int id){
        return userCache.get(id);
    }
}
