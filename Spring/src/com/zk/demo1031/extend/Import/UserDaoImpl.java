package com.zk.demo1031.extend.Import;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserDaoImpl implements UserDao{

	private static final Log log = LogFactory.getLog(UserDaoImpl.class);
	
	@Override
	public void login() {
		log.info("数据访问层：查询数据库，账号密码正确");
	}	
}