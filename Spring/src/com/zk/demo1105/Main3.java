package com.zk.demo1105;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class Main3 {
	
	public static final Log log = LogFactory.getLog(Main3.class);
	private static String xmlPath = "classpath:${user.dir}com/zk/demo1025/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
		StandardEnvironment environment=new StandardEnvironment();
		xmlPath=environment.resolvePlaceholders(xmlPath);
		
		DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
		Resource resource=defaultResourceLoader.getResource(xmlPath);
		log.info(defaultResourceLoader.getProtocolResolvers());
		log.info(resource);
	}
}