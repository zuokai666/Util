package com.zk.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author King
 */
public class Main1110 {
	
	public static final Log logger = LogFactory.getLog(Main1110.class);
	
	public static void main(String[] args) throws Exception {
		String configLocation="com/zk/aop/applicationContext.xml";
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext(configLocation);
		Counter counter = applicationContext.getBean("counter", Counter.class);
		counter.count();
	}
}