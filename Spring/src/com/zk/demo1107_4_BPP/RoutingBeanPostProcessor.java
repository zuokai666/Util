package com.zk.demo1107_4_BPP;

import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component("routingBeanPostProcessor")
public class RoutingBeanPostProcessor implements BeanPostProcessor,BeanFactoryAware{
	
	private static final Log log = LogFactory.getLog(RoutingBeanPostProcessor.class);
	
	private DefaultListableBeanFactory beanFactory;
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.info("----------------After Initialization postProcess:"+beanName);
		Class<?> clasz=bean.getClass();
		Field[] fields=clasz.getDeclaredFields();
		for(Field field:fields){
			if(field.isAnnotationPresent(RoutingInjected.class)){
				System.out.println(field.getType());
				if(field.getType().isAnnotationPresent(RoutingSwitch.class)){
					Object fieldObject=beanFactory.getBean(field.getType().getAnnotation(RoutingSwitch.class).value());
					field.setAccessible(true);
					try {
						field.set(bean, fieldObject);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return bean;
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory=(DefaultListableBeanFactory) beanFactory;
	}
}