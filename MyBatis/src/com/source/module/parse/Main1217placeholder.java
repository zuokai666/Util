package com.source.module.parse;

import java.util.Properties;

import org.apache.ibatis.parsing.PropertyParser;

public class Main1217placeholder {
	
	public static void main(String[] args) {
		Properties properties=new Properties();
		properties.setProperty("username", "zuokai");
		System.out.println(PropertyParser.parse("My name is ${username}", properties));
	}
}