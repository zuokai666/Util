package hibernate;

import javax.persistence.Entity;

import org.hibernate.cfg.Configuration;
import org.zk.scan.PackageScanner;
import org.zk.scan.StandardPackageScanner;
import org.zk.scan.condition.AnnotationClassIncludeCondition;

public class AutoCreateTableApp {
	
	public static void main(String[] args) throws Exception {
	    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	    addAnnotatedClass(configuration, "xin.ss.model");
	    configuration.buildSessionFactory();
    }
	
	public static void addAnnotatedClass(Configuration configuration,String basePackage){
		PackageScanner scanner = new StandardPackageScanner();
		scanner.addClassIncludeCondition(new AnnotationClassIncludeCondition(Entity.class));
		for(String className : scanner.scanByCondition(basePackage)){
			try {
				configuration.addAnnotatedClass(Class.forName(className));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}