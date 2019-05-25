package org.zk.scan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractPackageScanner implements PackageScanner {
	
	private List<ClassExcludeCondition> classExcludeConditions = new CopyOnWriteArrayList<>();
	private List<ClassIncludeCondition> classIncludeConditions = new CopyOnWriteArrayList<>();
	
	@Override
	public void addClassExcludeCondition(ClassExcludeCondition excludeCondition) {
		classExcludeConditions.add(excludeCondition);
	}
	@Override
	public void removeClassExcludeCondition(ClassExcludeCondition excludeCondition) {
		classExcludeConditions.remove(excludeCondition);
	}
	@Override
	public List<ClassExcludeCondition> getClassExcludeConditions() {
		return classExcludeConditions;
	}
	@Override
	public void addClassIncludeCondition(ClassIncludeCondition includeCondition) {
		classIncludeConditions.add(includeCondition);
	}
	@Override
	public void removeClassIncludeCondition(ClassIncludeCondition includeCondition) {
		classIncludeConditions.remove(includeCondition);
	}
	@Override
	public List<ClassIncludeCondition> getClassIncludeConditions() {
		return classIncludeConditions;
	}
	
	/**
	 * 根据排除条件和包括条件来综合判断一个类是否满足条件
	 */
	protected boolean isCandidateClass(String className){
		for(ClassExcludeCondition condition:getClassExcludeConditions()){
			if(condition.match(className)){
				return false;
			}
		}
		for(ClassIncludeCondition condition:getClassIncludeConditions()){
			if(condition.match(className)){
				return true;
			}
		}
		return false;
	}
	@Override
	public List<String> scanByCondition(String basePackage) {
		List<String> result = new ArrayList<>();
		for(String className : scanByNothing(basePackage)){
			if(isCandidateClass(className)){
				result.add(className);
			}
		}
		return result;
	}
}