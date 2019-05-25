package com.zk.demo1108;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanFactroyProcessor
 * 
 * @author King
 */
public class Main {
	
	public static final Log log = LogFactory.getLog(Main.class);
	private static final String xmlPath = "classpath:com/zk/demo1108/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		applicationContext.getBean("userDao");
		applicationContext.close();
	}
}