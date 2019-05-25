package com.zk.demo1028;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

public class Main1028 {

	public static void main(String[] args) {
		BeanDefinitionBuilder builder=BeanDefinitionBuilder.genericBeanDefinition(User.class);
		BeanDefinition beanDefinition=builder.getBeanDefinition();
		System.out.println(beanDefinition);
		System.err.println("-----------------------");
	}
}