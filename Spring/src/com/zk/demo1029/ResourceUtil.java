package com.zk.demo1029;

import java.util.Date;

import org.springframework.core.io.Resource;

public class ResourceUtil {
	
	public static void print(Resource resource) {
		if(resource == null) return;
		try {
			
			System.err.println("resource:"+resource.getClass());
			System.out.println("contentLength:"+resource.contentLength()+" bytes");
			System.out.println("lastModified:"+new Date(resource.lastModified()));
			
			System.out.println("exists:"+resource.exists());
			System.out.println("isFile:"+resource.isFile());
//			System.out.println("getFile:"+resource.getFile());
			System.out.println("getURL:"+resource.getURL());
			System.out.println("getURI:"+resource.getURI());
			
			System.out.println("getFilename:"+resource.getFilename());
			System.out.println("getDescription:"+resource.getDescription());
			
			System.out.println("getInputStream:"+resource.getInputStream());
			Thread.sleep(100);
			System.err.println("-----------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}