package com.zk.demo0102;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1025 {
	
	public static void main(String[] args) throws Exception {
		String xmlPath = "com/zk/demo0102/applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		{
			Task task=applicationContext.getBean("task0", Task.class);
			task.run();
		}
		{
			Task task=applicationContext.getBean("task1", Task.class);
			task.run();
		}
		{
			Task task=applicationContext.getBean("task2", Task.class);
			task.run();
		}
		{
			Task task=applicationContext.getBean("task3", Task.class);
			task.run();
		}
		applicationContext.close();
	}
}