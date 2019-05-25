package org.zk.scan;

import java.util.ArrayList;
import java.util.List;

public class StandardPackageScanner extends AbstractPackageScanner{
	
	@Override
	public List<String> scanByNothing(String basePackage) {
		List<String> result = new ArrayList<>();
		return result;
	}
}