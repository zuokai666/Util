package com.zk.demo1105;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static final Log log = LogFactory.getLog(Main.class);
	private static final String xmlPath = "classpath:com/zk/demo1025/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
//		GenericConversionService service = new GenericConversionService();
//      service.addConverter(new StringToDateConverter());
//		
//		DateWrapper dateWrapper=new DateWrapper();
//		BeanWrapper beanWrapper=new BeanWrapperImpl(dateWrapper);
//		beanWrapper.setConversionService(service);
//		beanWrapper.setPropertyValue("date", "2018-11-05 12:56:47");
//		dateWrapper.run();
		
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		applicationContext.close();
	}
}