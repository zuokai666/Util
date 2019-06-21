package com.source.module.reflection;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;

import com.zk.model.User;

public class Main1218 {
	
	public static void main1(String[] args) throws Exception {
		long f=System.currentTimeMillis();
		
		System.err.println("花费时间(ms):"+(System.currentTimeMillis()-f));
	}
	
	public static void main(String[] args) throws Exception {
//		Reflector reflector=new Reflector(User.class);
//		reflector.getClass();
//		Method getIdMethod=User.class.getMethod("setVersion",Integer.class);
//		Type getIdReturn=TypeParameterResolver.resolveReturnType(getIdMethod, User.class);
//		System.out.println(getIdReturn);
//		
//		Type[] getIdParams=TypeParameterResolver.resolveParamTypes(getIdMethod, User.class);
//		System.err.println(Arrays.toString(getIdParams));
		
		ObjectFactory objectFactory=new DefaultObjectFactory();
		User user=objectFactory.create(User.class);
		System.err.println(user);
	}
}