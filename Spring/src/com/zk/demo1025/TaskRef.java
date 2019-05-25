package com.zk.demo1025;

public class TaskRef{
	
	private int a=10;
	private int b=10;
	public void setA(int a) {
		this.a = a;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public void run() {
		System.out.println("TaskRef run,a="+a+",b="+b);
	}
}