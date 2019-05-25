package com.zk.demo1107_2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zk.demo1031.extend.componet.UserDao;
import com.zk.demo1031.extend.componet.UserService;

/**
 * component-scan
 * 
 * @author King
 */
public class Main {
	
	public static final Log log = LogFactory.getLog(Main.class);
	private static final String xmlPath = "classpath:com/zk/demo1107_2/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		applicationContext.getBean("userService", UserService.class).login();
		log.trace(applicationContext.getBean(UserDao.class));
		applicationContext.close();
	}
}