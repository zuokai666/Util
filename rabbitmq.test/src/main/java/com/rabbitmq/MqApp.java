package com.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rabbitmq")
public class MqApp{
	
	public static void main(String[] args) {
		SpringApplication aApp = new SpringApplication(MqApp.class);
		aApp.run(args);
	}
}