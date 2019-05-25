package com.zk.demo1025;

import org.springframework.core.convert.support.GenericConversionService;

public class ZGenericConversionService extends GenericConversionService{
	
	public ZGenericConversionService() {
		addConverter(new StringToDateConverter());
	}
}