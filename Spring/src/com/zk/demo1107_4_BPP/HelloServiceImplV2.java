package com.zk.demo1107_4_BPP;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service(value="helloServiceImplV2")
public class HelloServiceImplV2 implements HelloService{
	
	public static final Log log = LogFactory.getLog(HelloServiceImplV2.class);
	
	@Override
	public void sayHello() {
		log.info("Hello from V2");
	}
	
	@Override
	public void sayHi() {
		log.info("Hi from V2");
	}
}