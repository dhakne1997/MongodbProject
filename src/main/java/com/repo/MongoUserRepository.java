package com.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.entity.MongoUser;

public interface MongoUserRepository extends MongoRepository<MongoUser, String> {
}
