package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.MongoUser;
import com.repo.MongoUserRepository;

@Service
public class MongoUserService {
	    @Autowired
	    private MongoUserRepository userRepository;

	    public List<MongoUser> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public MongoUser getUserById(String id) {
	        return userRepository.findById(id).orElse(null);
	    }

	    public MongoUser createUser(MongoUser user) {
	        return userRepository.save(user);
	    }

	    public MongoUser updateUser(MongoUser user) {
	        return userRepository.save(user);
	    }

	    public void deleteUser(String id) {
	        userRepository.deleteById(id);
	    }
	}

