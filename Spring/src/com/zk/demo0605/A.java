package com.zk.demo0605;

import java.util.Iterator;
import java.util.Properties;

import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class A {

	public static void main(String[] args) throws Exception {
		String handlerMappingsLocation = DefaultNamespaceHandlerResolver.DEFAULT_HANDLER_MAPPINGS_LOCATION;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Properties mappings = PropertiesLoaderUtils.loadAllProperties(handlerMappingsLocation, classLoader);
		Iterator<Object> iterator = mappings.keySet().iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.err.println(object);
			System.out.println(mappings.get(object));
		}
	}
}