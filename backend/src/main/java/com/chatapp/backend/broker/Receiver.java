package com.chatapp.backend.broker;

import com.chatapp.backend.message.Message;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.user.SimpSession;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    // Interface for sending messages to WebSocket clients
    private final SimpMessageSendingOperations messagingTemplate;

    // Interface for managing WebSocket users and sessions
    private final SimpUserRegistry userRegistry;

    @KafkaListener(topics = "messaging", groupId = "chat")
    public void consume(Message chatMessage) {
        logger.info("Received message from Kafka: " + chatMessage);
        for (SimpUser user : userRegistry.getUsers()) {
            for (SimpSession session : user.getSessions()) {
                if (!session.getId().equals(chatMessage.getSessionId())) {
                    messagingTemplate.convertAndSendToUser(session.getId(), "/topic/public", chatMessage);
                }
            }
        }
    }
}