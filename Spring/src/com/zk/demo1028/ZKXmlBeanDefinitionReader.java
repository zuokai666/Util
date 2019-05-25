package com.zk.demo1028;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class ZKXmlBeanDefinitionReader extends XmlBeanDefinitionReader {

	public ZKXmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
		super(registry);
	}
	
	@Override
	public Document doLoadDocument(InputSource inputSource, Resource resource) throws Exception {
		return super.doLoadDocument(inputSource, resource);
	}
}