package com.zk.demo1025;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1025 {
	
//	void fun1() throws Exception {
//		String xmlPath = "com/zk/demo1025/applicationContext.xml";
//		String filePath = "E:\\applicationContext.xml";		
//		@SuppressWarnings("resource")
//		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
//		System.err.println(applicationContext.toString());
//		LoginService loginService = applicationContext.getBean("loginService",LoginService.class);
//		loginService.login("root", "123456");
//		System.out.println("-------------------");
//		System.err.println(applicationContext.getBeanFactory());
//		{
//			Resource resource=new ClassPathResource(filePath);
//			resource=new FileSystemResource(filePath);
//			System.out.println(resource.getFile());
//		}
//	}
	
	public static void main(String[] args) throws Exception {
		String xmlPath = "com/zk/demo1025/applicationContext.xml";
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		System.err.println(applicationContext.toString());
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
		LoginService loginService = beanFactory.getBean(LoginService.class);
		loginService.login("root", "123456");
		
		
//		System.out.println(beanFactory.toString());
//		System.err.println(beanFactory.getSingleton("loginService") == beanFactory.getBean("loginService",LoginService.class));
//		System.out.println("-------------------");
//		LoginService loginService = beanFactory.getBean("loginService",LoginService.class);
//		loginService.login("root", "123456");
//		System.out.println("-------------------");
//		beanFactory.getBean(LoginService.class);
//		System.err.println("taskFactory:"+beanFactory.getBean("taskFactory"));
//		System.err.println("&taskFactory:"+beanFactory.getBean("&taskFactory"));
//		{
//			System.err.println(beanFactory.getBean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME).getClass());
//			for(String beanName:beanFactory.getSingletonNames()){
//				System.out.println(beanName+": "+beanFactory.getBean(beanName).getClass());
//			}
//		}
	}
}