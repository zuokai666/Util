package com.zk.aop1112;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {
	
	public static final Log logger = LogFactory.getLog(Advice.class);
	
	public void before(){
		
	}
	public void afterMethod(){
		
	}
	public void afterReturning(){
		
	}
    public void afterThrowing(){
		
	}
    public Object around(ProceedingJoinPoint joinPoint){
    	long f=System.currentTimeMillis();
		try {
			Object result=joinPoint.proceed();
			long e=System.currentTimeMillis();
			logger.info("函数运行时间:"+(e-f)+"(ms)");
			return result;
		} catch (Throwable e1) {
			e1.printStackTrace();
			return null;
		}
	}
}