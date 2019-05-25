package com.zk.demo1031.extend.Import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
	
	@Bean(name="userService")
	public UserService userService(){
		return new UserService();
	}
}