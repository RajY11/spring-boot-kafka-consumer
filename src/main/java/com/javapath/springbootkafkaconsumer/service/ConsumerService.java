package com.javapath.springbootkafkaconsumer.service;

import com.javapath.springbootkafkaconsumer.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
   // @KafkaListener(topics = "User_Topic",groupId = "group_json", containerFactory = "concurrentKafkaListenerContainerFactory")
    @KafkaListener(topics = "User_Topic", groupId = "group_json")
    public void consumeUser(User user){
       // User user = (User) object;
        System.out.println(user.getName() + "with id" + user.getId() + "Consumed");
    }

    @Bean
    public StringJsonMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }
}
