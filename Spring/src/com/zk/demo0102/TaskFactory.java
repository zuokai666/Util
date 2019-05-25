package com.zk.demo0102;

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
	
	public static Task product(){
		return new Task();
	}
	
	public static class InnerTaskFactory{
		
		public Task getObject() throws Exception {
			return new Task();
		}
	}
}