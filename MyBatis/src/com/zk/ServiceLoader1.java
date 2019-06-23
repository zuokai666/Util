package com.zk;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoader1 {
	
	public static void main(String[] args) {
		ServiceLoader<Driver> loadedDrivers = ServiceLoader.load(Driver.class);
        Iterator<Driver> driversIterator = loadedDrivers.iterator();
        try{
            while(driversIterator.hasNext()) {
                System.err.println(driversIterator.next());
            }
        } catch(Throwable t) {
        	// Do nothing
        }
	}
}