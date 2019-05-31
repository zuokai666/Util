package osgi.test;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello World!!");
	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}
}