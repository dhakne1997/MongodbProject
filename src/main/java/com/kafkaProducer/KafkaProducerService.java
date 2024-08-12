package com.kafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.entity.MongoUser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class KafkaProducerService {


	@Value("${kafka.topic}")
	private String kafkatopic;
	

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	
	@Autowired
	Gson gson;


	public void addUserRequest(MongoUser user) {
		try {
			kafkaTemplate.send(kafkatopic, gson.toJson(user));
			System.out.println("userDetails Added Successful send request");
		} catch (Exception e) {
        System.err.println("Error userDetails not added Successful send request: " + e.getMessage());

		}
		
	}






//	public void sendStudentDetails(Student student) {
//			try {
//				kafkaTemplate.send(kafkatopic, gson.toJson(student));
//				System.out.println("StudentDetails added Successful send request");
//			} catch (Exception e) {
//		        System.err.println("Error StudentDetails not added Successful send request: " + e.getMessage());
//
//			}
//		}



		
	}

