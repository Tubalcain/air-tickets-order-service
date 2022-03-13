package com.example.airticketsorderservice.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    public static final String TOPIC = "air-tickets-order";

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    MessageProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendOrderMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
