package com.rabbitmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(WorkController.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private String queue = "pressureQueue";
	
	@RequestMapping(path="/send/{number}",method=RequestMethod.GET,produces = "application/json")
	public String send(@PathVariable("number") Integer number){
		for(int i=1;i<=number;i++){
			rabbitTemplate.convertAndSend(queue, i + "");
		}
		return "{\"result\":\"1\"}";
	}
}