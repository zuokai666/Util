package org.zk._0530;

public class LoadclassTest {
	
	static String[] classes = {
			"org.springframework.core.AliasRegistry",
			"org.springframework.core.AttributeAccessor",
			"org.springframework.core.AttributeAccessorSupport",
			"org.springframework.core.Constants",
			"org.springframework.core.DecoratingProxy"};
	
	public static void main(String[] args) throws Exception {
		Thread.sleep(30 * 1000);
		System.err.println("开始加载类");
		for(String clasz : classes){
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			Class<?> result = classLoader.loadClass(clasz);
			System.out.println(result);
			Thread.sleep(10 * 1000);
		}
	}
}