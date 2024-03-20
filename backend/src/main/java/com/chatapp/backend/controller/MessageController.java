package com.chatapp.backend.controller;

import com.chatapp.backend.broker.Sender;
import com.chatapp.backend.message.Message;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
@RequiredArgsConstructor
public class MessageController {

    private final Sender sender;

    private final SimpMessageSendingOperations messagingTemplate;
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @MessageMapping("/chat.send-message")
    public void sendMessage(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        chatMessage.setSessionId(headerAccessor.getSessionId());
        logger.info("Sending message to Kafka: " + chatMessage);
        sender.send("messaging", chatMessage);

        logger.info("Sending message to /topic/public: " + chatMessage);
        messagingTemplate.convertAndSend("/topic/public", chatMessage);

        logger.info("Message sent to /topic/public: " + chatMessage);
    }

    @MessageMapping("/chat.add-user")
    @SendTo("/topic/public")
    public Message addUser(
            @Payload Message chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        if (headerAccessor.getSessionAttributes() != null) {
            headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        }

        return chatMessage;
    }
}