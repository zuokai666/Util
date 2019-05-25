package com.zk.demo1106;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zk.demo1031.extend.componet.UserService;

/**
 * 非bean标签的解析,重点在于如何解析，关于其中的Processor如何起作用不是重点
 * 重点是：NamespaceHandler
 * @author King
 */
public class Main {
	
	public static final Log log = LogFactory.getLog(Main.class);
	private static final String xmlPath = "classpath:com/zk/demo1106/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService=applicationContext.getBean("userService", UserService.class);
		userService.login();
		log.info(applicationContext.getBean("a"));
		log.info(applicationContext.getBean("b"));
		log.info(applicationContext.getBean("c"));
		applicationContext.close();
		applicationContext.refresh();
		log.info(applicationContext.getBean("a"));
		log.info(applicationContext.getBean("b"));
		log.info(applicationContext.getBean("c"));
	}
}