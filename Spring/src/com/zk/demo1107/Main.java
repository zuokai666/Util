package com.zk.demo1107;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zk.demo1025.Task;

/**
 * 注解是如何起作用的？
 * 
 * 0.BeanPostProcessor是如何起作用的？
 * 答：initializeBean()中，invokeAwareMethods；applyBeanPostProcessorsBeforeInitialization；invokeInitMethods；applyBeanPostProcessorsAfterInitialization
 * 1.@Autowired 注解是如何注入的，依赖什么时候注入的？，AutowiredAnnotationBeanPostProcessor是她的作用吗与架构？
 * 2.autowire="byName"如何起作用
 *   答：populateBean()中，会判断是否byName/Type，然后调用autowireByName/Type方法
 * 
 * @author King
 */
public class Main {
	
	public static final Log log = LogFactory.getLog(Main.class);
	private static final String xmlPath = "classpath:com/zk/demo1107/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		Task task=applicationContext.getBean("task", Task.class);
		task.run();
		applicationContext.close();
	}
}