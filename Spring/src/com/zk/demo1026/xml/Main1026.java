package com.zk.demo1026.xml;

import java.util.HashMap;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.xml.XmlValidationModeDetector;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Main1026 {
	
	private static final String xmlPath = "classpath:com/zk/demo1026/xml/mybatis-config.xml";
	
	public static void main1(String[] args) throws Exception {
		long f=System.currentTimeMillis();
		DocumentLoader documentLoader=new DefaultDocumentLoader();
		ResourceLoader resourceLoader=new DefaultResourceLoader();
		Document document=documentLoader.loadDocument(new InputSource(resourceLoader.getResource(xmlPath).getInputStream()), 
				new ResourceEntityResolver(resourceLoader), null, XmlValidationModeDetector.VALIDATION_DTD, false);
		XPath xPath=XPathFactory.newInstance().newXPath();
		XPathExpression expression=xPath.compile("configuration/mappers/mapper");
		NodeList nodeList=(NodeList) expression.evaluate(document, XPathConstants.NODESET);
		for(int i=0;i<nodeList.getLength();i++){
			System.out.println(nodeList.item(i).getNodeName()+"-"+nodeList.item(i).getNodeType()
					+"-"+nodeList.item(i).getAttributes().getNamedItem("resource"));
		}
		System.err.println("花费时间(ms):"+(System.currentTimeMillis()-f));
	}
	
	public static void main(String[] args) {
		Map<String, Object> map=new HashMap<>();
		map.put("username", "zuokai");
		MutablePropertySources propertySources = new MutablePropertySources();
		propertySources.addLast(new MapPropertySource("1", map));
		PropertySourcesPropertyResolver propertyResolver=new PropertySourcesPropertyResolver(propertySources);
		System.out.println(propertyResolver.resolvePlaceholders("My name is ${username}"));
	}
}