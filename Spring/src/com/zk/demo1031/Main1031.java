package com.zk.demo1031;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Service;

import com.zk.demo1025.LoginService;

public class Main1031 {
	
	private static final Log log = LogFactory.getLog(Main1031.class);
	private static final String xmlPath = "classpath:com/zk/demo1025/applicationContext.xml";
	
	//环境是一个PropertySources（名词）属性源 与PropertyResolver属性解析器的结合，解析器在属性源中查找可以替换的值
	//StandardEnvironment实现了PropertyResolver，但是真正实现却在PropertySourcesPropertyResolver中，前提是先接口注入PropertySources
	void fun1(){
		StandardEnvironment environment=new StandardEnvironment();
		String path="${user.dir}\\a";
		String resolvePath=environment.resolveRequiredPlaceholders(path);
		log.debug(path+" -> "+resolvePath);
		log.debug("------------------------");
	}
	
	void fun2(){
		System.setProperty("name", "zk");
		StandardEnvironment environment=new StandardEnvironment();
		String path="classpath:com/${name}/demo1025/applicationContext.xml";
		String resolvePath=environment.resolveRequiredPlaceholders(path);
		log.debug(path+" -> "+resolvePath);
		log.debug("------------------------");
	}
	
	void fun3(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		log.debug("\r\n\r\n");
		applicationContext.getBean("loginService", LoginService.class).login("123", "456");
		log.debug("\r\n\r\n");
		applicationContext.close();
	}
	
	void fun4(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		applicationContext.getBean("loginService", LoginService.class).login("123", "456");
		applicationContext.close();
	}
	
	//ListableBeanFactory中的方法测试
	void fun5(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		log.debug(applicationContext.getBeansWithAnnotation(Service.class));
		log.debug("\r\n\r\n");
		applicationContext.close();
	}
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		applicationContext.getBean("loginService", LoginService.class).login("123", "456");
		applicationContext.close();
	}
}