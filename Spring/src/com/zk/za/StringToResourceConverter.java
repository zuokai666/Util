package com.zk.za;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

public class StringToResourceConverter implements Converter<String, Resource>{
	
	private ResourceLoader resourceLoader=new DefaultResourceLoader();
	
	@Override
	public Resource convert(String source) {
		Assert.hasLength(source, "source must not be null");
		return resourceLoader.getResource(source);
	}
}