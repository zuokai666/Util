package com.zk.demo1025;

import java.lang.annotation.Annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

public class ABeanPostProcessor implements BeanPostProcessor{
	
	private static final Log log = LogFactory.getLog(ABeanPostProcessor.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.info("----------------Before Initialization postProcess:"+beanName);
		Class<?> clasz=bean.getClass();
		Annotation annotation=clasz.getAnnotation(Component.class);
		if(annotation != null){
			log.info("----------------Before Initialization postProcess:"+annotation);
		}
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.info("----------------After Initialization postProcess:"+beanName);
		return bean;
	}
}