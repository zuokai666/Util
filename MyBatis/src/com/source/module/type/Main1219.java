package com.source.module.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

public class Main1219 {
	
	public static void main1(String[] args) throws Exception {
		long f=System.currentTimeMillis();
		
		System.err.println("花费时间(ms):"+(System.currentTimeMillis()-f));
	}
	
	public static void main(String[] args) throws Exception {
		TypeHandlerRegistry typeHandlerRegistry=new TypeHandlerRegistry();
		TypeHandler<Boolean> typeHandler1=typeHandlerRegistry.getTypeHandler(Boolean.class);
		System.out.println(typeHandler1.getClass());
		
		TypeHandler<?> typeHandler2=typeHandlerRegistry.getTypeHandler(JdbcType.BIT);
		System.out.println(typeHandler2.getClass());
	}
}