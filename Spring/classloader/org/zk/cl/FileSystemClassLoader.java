package org.zk.cl;

import java.io.IOException;

import org.springframework.core.io.FileSystemResource;

public class FileSystemClassLoader extends ClassLoader{
	
	private final FileSystemResource fileSystemResource;
	
	public FileSystemClassLoader(String path) {
		this.fileSystemResource = new FileSystemResource(path);
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		if(c == null){
			byte[] classData = null;
			try {
				classData = getClassData();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return defineClass(name, classData, 0, classData.length);
		}else {
			return c;
		}
	}
	
	private byte[] getClassData() throws IOException{
		int length = fileSystemResource.getInputStream().available();
		byte[] data = new byte[length];
		System.out.println("类文件:" + length);
		fileSystemResource.getInputStream().read(data, 0, length);
		return data;
	}
}