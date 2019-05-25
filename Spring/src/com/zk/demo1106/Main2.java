package com.zk.demo1106;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;

/**
 * BeanUtils.instantiateClass(Class)内部实现
 * @author King
 */
public class Main2 {
	
	public static final Log log = LogFactory.getLog(Main2.class);
	
	public static void main(String[] args) throws Exception {
		DefaultBeanDefinitionDocumentReader documentReader=BeanUtils.instantiateClass(DefaultBeanDefinitionDocumentReader.class);
		System.out.println(documentReader);
	}
}