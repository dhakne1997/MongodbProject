package com.kafkaConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.errors.SerializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.entity.MongoUser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;


@Service
public class KafkaConsumerService {@Autowired
	Gson gson;

	@Value("${kafka.topic}")
	private String kafkatopic;


	
	
	
	@KafkaListener(id ="my-project-topic-group1",topics="my-project-topic",containerFactory = "kafkaMEContainerFactory")
	public void listenToTopic1(ConsumerRecord<String, String> record) {
        try {
        	System.out.println(record.value());
            String user = record.value(); 
             MongoUser mongouser=gson.fromJson(user, MongoUser.class);
            System.out.println("The  message received for MongoUser: " + user.toString());
        } catch (SerializationException e) {
            System.err.println("Error deserializing message: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }

	

}
