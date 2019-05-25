package org.zk.scan;

import java.util.List;

/**
 * 包扫描器
 * 
 * @author King 2019-5-25 10:44:16
 *
 */
public interface PackageScanner {
	
	void addClassExcludeCondition(ClassExcludeCondition excludeCondition);
	void removeClassExcludeCondition(ClassExcludeCondition excludeCondition);
	List<ClassExcludeCondition> getClassExcludeConditions();
	
	void addClassIncludeCondition(ClassIncludeCondition includeCondition);
	void removeClassIncludeCondition(ClassIncludeCondition includeCondition);
	List<ClassIncludeCondition> getClassIncludeConditions();
	
	List<String> scanByCondition(String basePackage);
	List<String> scanByNothing(String basePackage);
}