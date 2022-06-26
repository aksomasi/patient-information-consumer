package com.techshard.activemq;

import org.apache.activemq.command.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@MessageMapping("/hello")
	@SendTo("/topic/greeting")
	public String greeting() {
		return "test";
	}
}
