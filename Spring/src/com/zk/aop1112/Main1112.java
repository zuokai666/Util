package com.zk.aop1112;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author King
 */
public class Main1112 {
	
	public static final Log logger = LogFactory.getLog(Main1112.class);
	
	public static void main(String[] args) throws Exception {
		xmlTest();
	}
	
	public static void xmlTest() {
		String configLocation="com/zk/aop1112/applicationContext.xml";
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext(configLocation);
//		CT counter = applicationContext.getBean("counterProxy", CT.class);
//		logger.info(counter.getClass().getClassLoader());
//		counter.count();
		
		for(String name:applicationContext.getBeanDefinitionNames()){
			logger.info(applicationContext.getBean(name).getClass());
		}
		logger.info(applicationContext.getBean("pointcut1").getClass());
//		applicationContext.close();
	}
	
	public static void programTest() {
		String configLocation="com/zk/aop1112/applicationContext.xml";
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext(configLocation);
		ProxyFactoryBean proxyFactoryBean=applicationContext.getBean("&counterProxy", ProxyFactoryBean.class);
		logger.info(proxyFactoryBean.isProxyTargetClass());
		for(Advisor advisor:proxyFactoryBean.getAdvisors()){
			logger.info(advisor);
		}
		
		ProxyConfig p=new ProxyConfig();
		logger.info(p.toString());
	}
}