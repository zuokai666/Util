package com.zk.demo1107_4_BPP;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author King
 */
public class Main {
	
	public static final Log log = LogFactory.getLog(Main.class);
	private static final String xmlPath = "classpath:com/zk/demo1107_4_BPP/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		log.info("-------------------------------");
		HelloController controller=applicationContext.getBean("helloController", HelloController.class);
		controller.sayHello();
		controller.sayHi();
		applicationContext.close();
	}
}