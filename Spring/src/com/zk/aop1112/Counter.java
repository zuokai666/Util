package com.zk.aop1112;

import org.springframework.stereotype.Component;

@Component("counter")
public class Counter implements CT {
	
	@Override
	public void count(){
		int i=Integer.MAX_VALUE;
		while(0 < i){
			i--;
		}
	}
}