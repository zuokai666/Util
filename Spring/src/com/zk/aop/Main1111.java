package com.zk.aop;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 
 * 编程式AOP
 * 代理对象类型：com.zk.aop.Counter$$EnhancerBySpringCGLIB$$5766705b
 * 
 * @author King
 */
public class Main1111 {
	
	public static final Log logger = LogFactory.getLog(Main1111.class);
	
	public static void main(String[] args) throws Exception {
		ProxyFactory proxyFactory=new ProxyFactory();
		proxyFactory.setTarget(new Counter());
		proxyFactory.addAdvice(new Advice1());
		Counter counter=(Counter) proxyFactory.getProxy();
		logger.info(counter.getClass());
		counter.count();
	}
	
	static class Advice1 implements MethodBeforeAdvice,AfterReturningAdvice{
		
		public static final Log logger = LogFactory.getLog(Advice1.class);
		
		@Override
		public void before(Method method, Object[] args, Object target) throws Throwable {
//			logger.info(System.currentTimeMillis());
			logger.info("栈帧入栈");
		}
		
		@Override
		public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
//			logger.info(System.currentTimeMillis());
			logger.info("栈帧出栈");
		}
	}
}