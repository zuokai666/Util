package com.zk.demo1025;

import org.springframework.core.io.Resource;

public class ResourceHolder {
	
	private Resource resource;
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	public void run(){
		System.out.println(resource.getClass());
	}
}