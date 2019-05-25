package com.zk.demo1031.extend.Import;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
		applicationContext.getBean("userService", UserService.class).login();
		applicationContext.close();
	}
}