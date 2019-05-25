package com.zk.demo1025;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("loginService")
public class LoginServiceImpl implements LoginService {
	
	public final Log log = LogFactory.getLog(getClass());
	
	public LoginServiceImpl() {
		if(log.isDebugEnabled()){
			log.debug("LoginServiceImpl <init>\r\n\r\n");
		}
	}
	
	public void start(){
		if(log.isDebugEnabled()){
			log.debug("LoginServiceImpl start方法\r\n\r\n");
		}
	}
	
	public void destroy(){
		if(log.isDebugEnabled()){
			log.debug("LoginServiceImpl destroy方法\r\n\r\n");
		}
	}
	
	@Override
	public void login(String account, String password) {
		System.out.println("实例1"+this.toString()+":"+account+"进行登录.");
	}
}