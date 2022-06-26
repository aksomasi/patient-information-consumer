package com.techshard.activemq.consumer;

import org.apache.activemq.command.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class MessageConsumer {

    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	@Autowired
	private SimpMessagingTemplate template;
    
    @JmsListener(destination = "test-queue")
    public void listener(String message){
        logger.info("Message received {} ", message);
		template.convertAndSend("/topic/greeting", message);
    }
}
