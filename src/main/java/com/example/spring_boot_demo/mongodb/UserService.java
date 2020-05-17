package com.example.spring_boot_demo.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : UserService
 * @Description :
 * @Author : sky
 * @Date: 2020-05-10 21:28
 */
@Service
public class UserService {
    @Autowired(required = false)
    private IMongoDbUserDao userDao;

    @Autowired
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

    /**
     * 默认按照由近到远排序
     * @param lng  经度 竖，y
     * @param lat 维度  横，x
     * @return
     */
    public List<User> getNearLocation(double lng, double lat) {
        Query query = new Query();
        Point point = new Point(lat,lng);
        Criteria locCri = Criteria.where("loc").nearSphere(point);
        //locCri.size(10);
        query.addCriteria(locCri);
        Pageable pageable = PageRequest.of(0, 5); // 分页
        query.with(pageable);
        List<User> users = mongoTemplate.find(query, User.class);
       // System.out.println(users);
        return users;
        //return mongoAccess.find(query, Location.class);
    }

    /**
     * 以某个点为中心的圆几公里以内的位置数据
     * @param lng
     * @param lat
     * @param radius
     * @return
     */
    public List<User> getCircleLocation(double lng, double lat, double radius) {
        //获取半径内的所有位置
        Point point = new Point(lat,lng);
        Distance distance = new Distance(radius, Metrics.KILOMETERS);//指定位置單位
        Circle circle = new Circle(point, distance);
        Criteria locCri = Criteria.where("loc").withinSphere(circle);
        Query query = new Query();
        query.addCriteria(locCri);
        Pageable pageable = PageRequest.of(0, 5); // 分页
        query.with(pageable);
        return mongoTemplate.find(query, User.class);
    }
 }
