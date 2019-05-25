package com.zk.demo1029;

import java.nio.charset.Charset;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

import com.zk.demo1025.LoginService;

public class Main1029 {

	private static final String url = "http://www.d2p9.org/update/InteligentSite_Client_Android/applicationContext.xml";
	private static final String file = "file:D:\\JavaWork\\Spring\\src\\com\\zk\\demo1025\\applicationContext.xml";
	private static final String classpath = "com/zk/demo1025/applicationContext.xml";

	public static void main(String[] args) {
		fun3();
	}
	
	private static void fun3() {
		ResourceLoader resourceLoader=new DefaultResourceLoader();
		System.err.println("classpath:"+resourceLoader.getResource(classpath).getClass());
		System.out.println("file:"+resourceLoader.getResource(file).getClass());
//		System.err.println("url:"+resourceLoader.getResource(url));
	}
	
	@SuppressWarnings("unused")
	private static void fun2() {
		Resource resource=null;
		resource=new ClassPathResource(classpath);
		ResourceUtil.print(resource);
		resource=new FileSystemResource(file);
		ResourceUtil.print(resource);
		try {
			resource=new UrlResource(url);
			System.err.println("协议:"+resource.getURL().getProtocol());
			ResourceUtil.print(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resource=new ByteArrayResource("123".getBytes(Charset.forName("UTF-8")));
		ResourceUtil.print(resource);
	}
	
	public static void fun1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(url);
		System.err.println(applicationContext.toString());
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
		System.out.println(beanFactory.toString());
		beanFactory.getBean("loginService",LoginService.class).login("123", "456");
		applicationContext.close();
	}
}