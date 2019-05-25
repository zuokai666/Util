package com.zk.demo1105;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.zk.demo1025.DateWrapper;

public class Main2 {
	
	public static final Log log = LogFactory.getLog(Main2.class);
	
	public static void main(String[] args) throws Exception {
		DateWrapper dateWrapper=new DateWrapper();
		BeanWrapper beanWrapper=new BeanWrapperImpl(dateWrapper);
//		beanWrapper.setPropertyValue("date", "2018-11-05 12:56:47");
//		beanWrapper.setPropertyValue("a", "2014");
		beanWrapper.setPropertyValue("b", new ArrayList<>());
		dateWrapper.run();
	}
}