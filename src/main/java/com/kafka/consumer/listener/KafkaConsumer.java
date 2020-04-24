package com.kafka.consumer.listener;

import com.google.gson.Gson;
import com.kafka.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics =  "topic_string", groupId = "consumer")
    public void consumeString(String message) {
        System.out.println("Received String message: " + message);
    }

    @KafkaListener(topics = "topic_json", groupId = "json_id", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Received Json message: " + user.toString());
    }

}

