package com.zk.demo1107_4_BPP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller(value="helloController")
public class HelloController{
	
	@Autowired
	@Qualifier("helloServiceImplV2")
	private HelloService helloService;
	
	public void sayHello() {
		helloService.sayHello();
	}
	
	public void sayHi() {
		helloService.sayHi();
	}
}