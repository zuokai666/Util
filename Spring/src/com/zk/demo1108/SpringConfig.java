package com.zk.demo1108;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zk.demo1031.extend.UserDao;
import com.zk.demo1031.extend.UserDaoImpl;

@Configuration
public class SpringConfig {
	
	@Bean(name="userDao")
	public UserDao userDao(){
		return new UserDaoImpl();
	}
}