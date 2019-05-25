package com.zk.demo1031.extend.componet;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:com/zk/demo1031/extend/componet/applicationContext.xml");
//		applicationContext.getBean("userService", UserService.class).login();
//		applicationContext.close();
		for(String name:applicationContext.getBeanDefinitionNames()){
			System.err.println(name);
			System.out.println(applicationContext.getBean(name));
		}
	}
}