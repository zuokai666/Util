package com.zk.demo0103;

public class Task implements Runnable{
	
	private Person person;
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void run() {
		System.out.println(person.getName()+" task run");
	}
	
	public void init(){
		System.out.println(person.getName()+" task init");
	}
	
	public void destroy(){
		System.out.println(person.getName()+" task destroy");
	}
}