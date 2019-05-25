package com.zk.aop1113;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zk.aop1112.CT;

/**
 * 
 * @author King
 */
public class Main1113 {
	
	public static final Log logger = LogFactory.getLog(Main1113.class);
	
	public static void main(String[] args) throws Exception {
		xmlTest();
	}
	
	public static void xmlTest() {
		String configLocation="com/zk/aop1113/applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext(configLocation);
		CT counter = applicationContext.getBean("counter", CT.class);
		counter.count();
		applicationContext.close();
	}
}