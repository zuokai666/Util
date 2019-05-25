package com.zk.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.zk.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	public static final Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	@Override
	public User login(String account, String password) {
		return new User("zk", 100);
	}
}