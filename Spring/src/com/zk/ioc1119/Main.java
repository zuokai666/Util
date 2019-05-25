package com.zk.ioc1119;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

import com.zk.ioc1119.at.SpringConfig;
import com.zk.model.User;

/**
 * 研究2个对象的藏匿位置
 * 
 * 单例对象藏匿于org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.singletonObjects成员变量中
 * 工厂创建的单例对象藏匿于org.springframework.beans.factory.support.FactoryBeanRegistrySupport.factoryBeanObjectCache成员变量中
 * 
 * @author King
 * 
 */
public class Main {
	
	public static final Log log = LogFactory.getLog(Main.class);
	
	/**
	 * 编程式使用xml方式
	 * @return
	 */
	public static DefaultListableBeanFactory xml() {
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions("com/zk/ioc1119/xml/applicationContext.xml");
		return beanFactory;
	}
	
	/**
	 * 编程式使用at方式
	 * 2018年11月17日14:00:45  还得在研究一下AnnotationConfigApplicationContext的refresh过程才行
	 * 
	 * （here结束）
	 * 
	 * @return
	 */
	public static DefaultListableBeanFactory at() {
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		AnnotatedBeanDefinitionReader reader=new AnnotatedBeanDefinitionReader(beanFactory);
		reader.register(SpringConfig.class);
		ConfigurationClassPostProcessor postProcessor=new ConfigurationClassPostProcessor();
		postProcessor.postProcessBeanDefinitionRegistry(beanFactory);
		return beanFactory;
	}
	
	public static void main(String[] args) throws Exception {
//		DefaultListableBeanFactory beanFactory = at();
//		UserService userService=beanFactory.getBean("userService", UserService.class);
//		log.info(userService);
//		
//		ClassPathResource resource=new ClassPathResource("");
//		resource.getInputStream();
		
		User user=new User("", 1);
		log.info(user.hashCode());
		log.info(user.toString());
	}
}