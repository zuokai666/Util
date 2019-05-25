package com.zk.service;

import com.zk.model.User;

public interface UserService {
	
	User login(String account,String password);
}