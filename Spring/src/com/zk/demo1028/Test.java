package com.zk.demo1028;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.lang.NonNull;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class Test {
	
	public void p(@NonNull String str){
		System.out.println(str);
	}
	
	public static void main(String[] args) throws Exception {
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		ZKXmlBeanDefinitionReader reader=new ZKXmlBeanDefinitionReader(beanFactory);
		String xmlPath = "com/zk/demo1025/applicationContext.xml";
		ClassPathResource resource=new ClassPathResource(xmlPath);
		InputSource inputSource = new InputSource(resource.getInputStream());
		Document doc = reader.doLoadDocument(inputSource, resource);
		System.out.println(doc.getChildNodes());
	}
}