package com.zk.demo1025;

import java.util.Date;
import java.util.List;

public class DateWrapper {
	
	private Date date;
	public void setDate(Date date) {
		this.date = date;
	}
	
	private Integer a;
	public void setA(Integer a) {
		this.a = a;
	}
	
	private List<Object> b;
	public void setB(List<Object> b) {
		this.b = b;
	}
	
	public void run(){
		System.err.println(date);
		System.out.println(a);
		System.err.println(b);
	}
}