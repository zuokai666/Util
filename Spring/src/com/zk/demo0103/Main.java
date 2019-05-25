package com.zk.demo0103;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring DI生命周期
 * @author King
 *
 */
public class Main {
	
	static ThreadLocal<Object> threadLocal;
	
	public static void main(String[] args) throws Exception {
		String xmlPath = "com/zk/demo0103/applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
//		applicationContext.registerShutdownHook();//程序关闭，自动调用close函数
		{
			Task task=applicationContext.getBean("task", Task.class);
			task.run();
		}
		applicationContext.close();
	}
}