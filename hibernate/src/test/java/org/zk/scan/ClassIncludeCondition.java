package org.zk.scan;

/**
 * 类包括条件
 * 
 * @author King
 *
 */
public interface ClassIncludeCondition {
	
	boolean match(String className);
}