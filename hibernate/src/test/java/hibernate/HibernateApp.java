package hibernate;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class HibernateApp {
	
	public static void main(String[] args) throws Exception {
	    Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    scan(configuration);
	    SessionFactory factory = configuration.buildSessionFactory();
	    factory.openSession();
    }
	
	public static void scan(Configuration configuration) throws ClassNotFoundException {
		BeanDefinitionRegistry registry = new DefaultListableBeanFactory();
		boolean useDefaultFilters = false;
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, useDefaultFilters);
	    scanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
		scanner.setIncludeAnnotationConfig(false);
	    scanner.scan("xin.ss.model");
		for(String beanName:registry.getBeanDefinitionNames()){
			BeanDefinition bd = registry.getBeanDefinition(beanName);
			if(bd instanceof GenericBeanDefinition){
				System.out.println(bd.getBeanClassName());
				configuration.addAnnotatedClass(Class.forName(bd.getBeanClassName()));
			}else {
				System.err.println(bd);
			}
		}
	}
}