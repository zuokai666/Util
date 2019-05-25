package com.zk.demo1104;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static final Log log = LogFactory.getLog(Main.class);
	private static final String xmlPath = "classpath:com/zk/demo1025/applicationContext.xml";
	private static String name="resourceHolder";
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		log.info("\r\n\r\n");
//		log.info(Arrays.toString(applicationContext.getAliases(name)));
//		log.info(applicationContext.getType("resourceHolder1"));
//		applicationContext.isTypeMatch("resourceHolder", ResourceHolder.class);
		applicationContext.isPrototype(name);
		applicationContext.close();
	}
}