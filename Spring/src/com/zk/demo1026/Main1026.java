package com.zk.demo1026;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class Main1026 {
	
	private static final String xmlPath = "classpath:com/zk/demo1025/applicationContext.xml";

	public static void main(String[] args) throws Exception {
		fun3();
	}
	
	//xml
	public static void fun1() {
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(xmlPath);
	}
	
	//注解
	public static void fun2() {
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		ClassPathBeanDefinitionScanner scanner=new ClassPathBeanDefinitionScanner(beanFactory);
		scanner.scan("com.zk.demo1026");
		for(String name:beanFactory.getBeanDefinitionNames()){
			System.err.println(name);
		}
	}
	
	//注解
	public static void fun3() {
		AnnotationConfigApplicationContext appCon = new AnnotationConfigApplicationContext();
		appCon.scan("com.zk.demo1026");
		appCon.refresh();
		for(String name:appCon.getBeanDefinitionNames()){
			System.err.println(name);
		}
		appCon.close();
	}
}