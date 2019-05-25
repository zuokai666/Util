package com.zk.demo1107_4_BPP;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service(value="helloServiceImplV1")
public class HelloServiceImplV1 implements HelloService{
	
	public static final Log log = LogFactory.getLog(HelloServiceImplV1.class);
	
	@Override
	public void sayHello() {
		log.info("Hello from V1");
	}
	
	@Override
	public void sayHi() {
		log.info("Hi from V1");
	}
}