package com.zk.demo1031.extend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
	
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(Main1.class);
	
	public static void fun1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:com/zk/demo1031/extend/applicationContext.xml");
		applicationContext.getBean("userService", UserService.class).login();
		applicationContext.close();
	}
	public static void fun2(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
		applicationContext.getBean("userService", UserService.class).login();
		applicationContext.close();
	}
	
	public static void main(String[] args) {
		fun2();
	}
}