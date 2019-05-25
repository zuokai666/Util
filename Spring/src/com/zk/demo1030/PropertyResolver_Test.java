package com.zk.demo1030;

import org.springframework.core.env.StandardEnvironment;

public class PropertyResolver_Test {
	
	public static void main(String[] args) {
		StandardEnvironment propertyResolver=new StandardEnvironment();
		System.err.println(propertyResolver.getSystemEnvironment());
	}
}