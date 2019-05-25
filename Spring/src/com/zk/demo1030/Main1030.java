package com.zk.demo1030;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.SpringVersion;
import org.springframework.core.io.ClassPathResource;

public class Main1030 {
	
	private static final String xmlPath = "classpath:com/zk/demo1025/applicationContext.xml";
	
	public static void main(String[] args) throws Exception {
		Package pkg = SpringVersion.class.getPackage();
		System.out.println(pkg.getImplementationVersion());
		System.err.println(pkg.toString());
		
		fun3();
	}
	
	@SuppressWarnings("unused")
	private static void fun1() {
		ClassPathResource resource=new ClassPathResource(xmlPath);
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(resource);
	}
	
	@SuppressWarnings("unused")
	private static void fun2() {
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		PropertiesBeanDefinitionReader reader=new PropertiesBeanDefinitionReader(beanFactory);//使用情况
	}
	
	private static void fun3(){
		Package[] pack = Package.getPackages();

	      // print all packages, one by one
	      for (int i = 0; i < pack.length; i++) {
	         System.out.println("" + pack[i]);
	      }
	}
}