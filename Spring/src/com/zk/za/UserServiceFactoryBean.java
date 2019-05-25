package com.zk.za;

import org.springframework.beans.factory.FactoryBean;

import com.zk.service.UserService;
import com.zk.service.UserServiceImpl;

public class UserServiceFactoryBean implements FactoryBean<UserService>{
	
	@Override
	public UserService getObject() throws Exception {
		return new UserServiceImpl();
	}
	
	@Override
	public Class<?> getObjectType() {
		return UserService.class;
	}
	
	@Override
	public boolean isSingleton() {
		return true;
	}
}