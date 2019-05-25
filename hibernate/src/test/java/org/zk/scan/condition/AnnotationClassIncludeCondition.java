package org.zk.scan.condition;

import java.lang.annotation.Annotation;

import org.zk.scan.ClassIncludeCondition;

/**
 * 注解-类包括条件
 * @author King
 *
 */
public class AnnotationClassIncludeCondition implements ClassIncludeCondition{
	
	private Class<? extends Annotation> annotationClass;
	
	public AnnotationClassIncludeCondition(Class<? extends Annotation> annotationClass) {
		this.annotationClass = annotationClass;
	}
	
	@Override
	public boolean match(String className) {
		try {
			Class<?> _class = Class.forName(className);
			if(_class.isAnnotationPresent(annotationClass)){
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}