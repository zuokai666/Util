package com.source.module.io;

import org.apache.ibatis.io.ResolverUtil;

public class Main1219 {

	public static void main(String[] args) {
		ResolverUtil<Object> resolverUtil=new ResolverUtil<>();
		resolverUtil.findImplementations(Object.class, "com.source");
		for(Class<?> clasz:resolverUtil.getClasses()){
			System.out.println(clasz);
		}
	}
}