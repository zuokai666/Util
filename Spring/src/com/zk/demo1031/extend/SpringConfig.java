package com.zk.demo1031.extend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean(name="userDao")
	public UserDao userDao(){
		return new UserDaoImpl();
	}
	
	@Bean(name="userService")
	public UserService userService(){
		return new UserService();
	}
}