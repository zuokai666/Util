package com.zk.Test.ognl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ognl.Ognl;
import ognl.OgnlContext;

public class Main0102 {
	
	static final Logger log=LoggerFactory.getLogger(Main0102.class);
	
	static Thread thread=new Thread();
	
	public static void main(String[] args) throws Exception {
		OgnlContext context=new OgnlContext();
		context.setRoot(thread);
		Object value = Ognl.getValue(Ognl.parseExpression("@Thread@currentThread()"), context, context.getRoot());
		System.err.println(value.getClass()+":"+value);
	}
}