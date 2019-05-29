package com.zk.demo20190529;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.StandardEnvironment;

public class Main1031 {
	
	private static final Log log = LogFactory.getLog(Main1031.class);
	
	//环境是一个PropertySources（名词）属性源 与PropertyResolver属性解析器的结合，解析器在属性源中查找可以替换的值
	//StandardEnvironment实现了PropertyResolver，但是真正实现却在PropertySourcesPropertyResolver中，
	//前提是先接口注入PropertySources
	public static void fun1(){
		StandardEnvironment environment=new StandardEnvironment();
		Map<String, Object> source = new HashMap<>();
		source.put("person.name", "zuokai");
		environment.getPropertySources().addLast(new MapPropertySource("cc", source));
		String path="${person.name}";
		String resolvePath=environment.resolveRequiredPlaceholders(path);
		log.debug(path+" -> "+resolvePath);
		log.debug("------------------------");
		log.debug(environment.getProperty("person.name"));
	}
	
	@SuppressWarnings("unchecked")
	public static void fun11(){
		System.setProperty("name", "1,b,2,a");
		StandardEnvironment environment=new StandardEnvironment();
		List<String> resolvePath=environment.getRequiredProperty("${name}", List.class);
		log.debug("${name}"+" -> "+resolvePath);
		log.debug("------------------------");
	}
	
	public static void fun2(){
		System.setProperty("name", "zk");
		StandardEnvironment environment=new StandardEnvironment();
		String path="classpath:com/${name}/demo1025/applicationContext.xml";
		String resolvePath=environment.resolveRequiredPlaceholders(path);
		log.debug(path+" -> "+resolvePath);
		log.debug("------------------------");
	}
	
	public static void main(String[] args) {
		fun1();
	}
}