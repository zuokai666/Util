package com.zk.demo1101;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static final Log log = LogFactory.getLog(Main.class);
	private static final String xmlPath = "classpath:com/zk/demo1025/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		log.info("---------------------");
//		applicationContext.getBean("task", Task.class).run();
		for(String name:applicationContext.getBeanDefinitionNames()){
			log.info(name + ":" +applicationContext.getBean(name));
		}
		log.info("---------------------");
		log.info("BeanPostProcessorCount:"+applicationContext.getBeanFactory().getBeanPostProcessorCount());
		DefaultListableBeanFactory beanFactory=(DefaultListableBeanFactory) applicationContext.getBeanFactory();
		for(BeanPostProcessor beanPostProcessor:beanFactory.getBeanPostProcessors()){
			log.info(beanPostProcessor);
		}
		log.info(Arrays.toString(beanFactory.getDependenciesForBean("task")));
		log.info(Arrays.toString(beanFactory.getDependentBeans("taskRef")));
		beanFactory.registerDependentBean("", "");
	}
}