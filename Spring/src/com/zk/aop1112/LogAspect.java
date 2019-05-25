package com.zk.aop1112;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logAspect")
@Aspect
public class LogAspect {
	
	@Pointcut("execution(* com.zk.aop1112.Counter.*(..))")
    public void p(){
		
	}
	
    @Before("p()")
    public void p1(){
        System.out.println("Spring AOP @Before");
    }
    
    @After("p()")
    public void p2(){
        System.out.println("Spring AOP @After");
    }
}