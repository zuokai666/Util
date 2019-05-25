package com.zk.demo1025;

import org.springframework.beans.factory.annotation.Autowired;

public class Task implements Runnable{
	
	@Autowired
	private TaskRef taskRef;
	
	@Override
	public void run() {
		System.out.println("task run");
		taskRef.run();
	}
}