package com.example.spring_boot_demo.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMongoDbUserDao  extends MongoRepository<User, Integer> {

}
