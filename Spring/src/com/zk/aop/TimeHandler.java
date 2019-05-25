package com.zk.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TimeHandler {
	
	public static final Log logger = LogFactory.getLog(TimeHandler.class);
	
	public void before(){
		logger.info(System.currentTimeMillis());
	}
	
	public void after(){
		logger.info(System.currentTimeMillis());
	}
}