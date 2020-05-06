package com.example.spring_boot_demo.jetcache.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.example.spring_boot_demo.entity.User;

public interface IuserService {
    public void  save(User u);
    @CacheInvalidate(name="userCache:",key = "#userId")
    public void delete(int userId);

    @CacheUpdate(name="userCache:",key="#u.id", value="#u")
    public void update(User u);

    @Cached(name="userCache:", key="#userId", expire = 3600,cacheType = CacheType.REMOTE)
    public  User getById(int userId);
}
