package com.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "Mongo_User")
public class MongoUser {
@Id
	private String id;
    private String name;
    private String email;
    private int age;

}
