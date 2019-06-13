package com.rabbitmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues={"pressureQueue"}, autoStartup="false")
public class ConsumerController1 {
	
	private static final Logger log = LoggerFactory.getLogger(ConsumerController1.class);
	
	@RabbitHandler
	public void consume(String request){
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		log.info("[{}]-consume-{}",Thread.currentThread().getName(), request);
	}
}