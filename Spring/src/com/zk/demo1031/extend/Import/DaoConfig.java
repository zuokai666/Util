package com.zk.demo1031.extend.Import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
	
	@Bean(name="userDao")
	public UserDao userDao(){
		return new UserDaoImpl();
	}
}