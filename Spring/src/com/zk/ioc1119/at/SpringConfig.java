package com.zk.ioc1119.at;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zk.service.UserService;
import com.zk.service.UserServiceImpl;

@Configuration("springConfig")
public class SpringConfig {
	
	@Bean
	public UserService userService(){
		return new UserServiceImpl();
	}
}