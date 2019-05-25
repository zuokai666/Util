package com.zk.model;

public class User {
	
	private Long id;
	
	private Integer version;
	
	private String name;
	private String account;
	private String password;
	private int money;
	
	
	
	public User(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
//	@Override
//	public String toString() {
//		return "User [name=" + name + ", money=" + money + "]";
//	}	
}