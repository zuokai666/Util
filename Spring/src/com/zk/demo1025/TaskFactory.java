package com.zk.demo1025;

import org.springframework.beans.factory.FactoryBean;

public class TaskFactory implements FactoryBean<Task>{

	@Override
	public Task getObject() throws Exception {
		return new Task();
	}
	
	@Override
	public Class<?> getObjectType() {
		return Task.class;
	}
}