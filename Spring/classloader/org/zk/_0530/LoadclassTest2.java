package org.zk._0530;

import org.zk.cl.FileSystemClassLoader;

public class LoadclassTest2 {
	
	static String path = "C:/Users/zuoka/git/Util/Spring/a/b/Person.class";
	
	static FileSystemClassLoader fileSystemClassLoader1 = new FileSystemClassLoader(path);
	static FileSystemClassLoader fileSystemClassLoader2 = new FileSystemClassLoader(path);
	
	public static void main(String[] args) throws Exception {
		Class<?> _class1 = Class.forName("a.b.Person", true, fileSystemClassLoader1);
		Class<?> _class3 = Class.forName("a.b.Person", true, fileSystemClassLoader1);
		
		Class<?> _class2 = Class.forName("a.b.Person", true, fileSystemClassLoader2);
		
		System.out.println(_class1 == _class3);
		System.err.println(_class1 == _class2);
		
//		Class.forName("a.b.Person");
	}
	
	public static void main23(String[] args) throws Exception {
		Class<?> _class1 = fileSystemClassLoader1.loadClass("a.b.Person");
		Class<?> _class3 = fileSystemClassLoader1.loadClass("a.b.Person");
		
		Class<?> _class2 = fileSystemClassLoader2.loadClass("a.b.Person");
		
		System.out.println(_class1 == _class3);
		System.err.println(_class1 == _class2);
	}
}