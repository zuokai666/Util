package com.zk.demo19_0622;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class Main {
	
	public static void main(String[] args) {
		BeanDefinitionRegistry registry = new DefaultListableBeanFactory();
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
		scanner.setIncludeAnnotationConfig(false);
		System.out.println(1);
		try {
			Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println(2);
		System.err.println(scanner.scan("com.zk.demo19_0622.test"));
		System.err.println(registry.getBeanDefinitionCount());
		try {
			Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}