package com.zk.demo1026;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ZkConfig {
	
	@Bean
	public ConversionService conversionService(){
		return new DefaultConversionService();
	}
}