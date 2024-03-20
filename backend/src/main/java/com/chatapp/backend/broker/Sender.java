package com.chatapp.backend.broker;

import com.chatapp.backend.message.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    private final KafkaTemplate<String, Message> kafkaTemplate;

    public Sender(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Publishing message to Kafka topic
    public void send(String topic, Message message) {
        kafkaTemplate.send(topic, message);
    }
}
