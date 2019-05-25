package com.zk.demo1105;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class Main4 {
	
	public static final Log log = LogFactory.getLog(Main4.class);
	private static String locationPattern = "classpath*:com/zk/demo*/**/**/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
		PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		for(Resource resource:resolver.getResources(locationPattern)){
			log.info(resource);
		}
	}
}