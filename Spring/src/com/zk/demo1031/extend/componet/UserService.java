package com.zk.demo1031.extend.componet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {
	
	private static final Log log = LogFactory.getLog(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	public void login(){
		log.info("服务层：开始验证账号密码");
		userDao.login();
	}
}