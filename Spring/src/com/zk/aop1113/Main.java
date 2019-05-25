package com.zk.aop1113;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import com.zk.aop1112.Counter;

/**
 * 
 * @author King
 */
public class Main {
	
	public static final Log logger = LogFactory.getLog(Main.class);
	
	public static void main(String[] args) throws Exception {
		String expression = "execution(* com.zk.aop1112.Counter.*(..))";
		AspectJExpressionPointcut pointcut=new AspectJExpressionPointcut();
		pointcut.setExpression(expression);
		boolean res=pointcut.matches(Counter.class.getMethod("count"), Counter.class);
		logger.info(res);
		
		
//		PatternParser parser = new PatternParser(expression);
//		Pointcut pc = parser.parsePointcut();
	}
}