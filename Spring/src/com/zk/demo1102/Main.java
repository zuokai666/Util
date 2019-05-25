package com.zk.demo1102;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class Main {
	
	private static final Log log = LogFactory.getLog(Main.class);
	private static final String xmlPath = "classpath:com/zk/demo1025/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DefaultListableBeanFactory beanFactory=(DefaultListableBeanFactory) applicationContext.getBeanFactory();
		log.info(beanFactory.getBeansWithAnnotation(Service.class));
		applicationContext.close();
	}
}