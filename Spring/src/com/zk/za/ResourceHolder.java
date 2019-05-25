package com.zk.za;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;

public class ResourceHolder {
	
	public static final Log logger = LogFactory.getLog(ResourceHolder.class);
	
	private Resource resource;
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	
	public void run(){
		logger.info(resource);
	}
}