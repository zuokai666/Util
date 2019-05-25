package org.zk.scan;

/**
 * 类排除条件
 * 
 * @author King
 *
 */
public interface ClassExcludeCondition {
	
	boolean match(String className);
}