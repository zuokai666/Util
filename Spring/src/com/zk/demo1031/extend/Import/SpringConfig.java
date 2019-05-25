package com.zk.demo1031.extend.Import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DaoConfig.class,ServiceConfig.class})
public class SpringConfig {
	
}