package com.zk.demo1101;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;

import com.zk.demo1025.TaskRef;

public class Main2 {
	
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(Main2.class);
	
	public static void main(String[] args) throws Exception {
		TaskRef taskRef=new TaskRef();
		taskRef.run();
		BeanWrapper bw=new BeanWrapperImpl(taskRef);
		MutablePropertyValues pvs=new MutablePropertyValues();
		pvs.addPropertyValue("a", 99);
		pvs.addPropertyValue("b", 99);
		bw.setPropertyValues(pvs);
		taskRef.run();
	}
}