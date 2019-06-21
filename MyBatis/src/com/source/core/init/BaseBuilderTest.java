package com.source.core.init;

import java.io.InputStream;

import org.apache.ibatis.builder.BaseBuilder;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.scripting.xmltags.DynamicSqlSource;
import org.apache.ibatis.session.Configuration;

import com.zk.model.User;

public class BaseBuilderTest extends BaseBuilder{
	
	public BaseBuilderTest() {
		super(new Configuration());
	}
	
	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		InputStream inputStream = ClassLoader.getSystemResourceAsStream(resource);
		XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, null, null);
		Configuration config=parser.parse();
		
		for(MappedStatement mappedStatement:config.getMappedStatements()){
			System.out.println(mappedStatement.getSqlSource().getBoundSql(null).getSql());
		}
		User user=new User();
		user.setAccount("1");
		user.setPassword("2");
		DynamicSqlSource sqlSource = (DynamicSqlSource) config.getMappedStatement("selectUserByParms1").getSqlSource();
		System.out.println(sqlSource);
		for(ParameterMapping parameterMapping:sqlSource.getBoundSql(user).getParameterMappings()){
			System.out.println(parameterMapping);
		}
		System.err.println(sqlSource.getBoundSql(user).getSql());
	}
}