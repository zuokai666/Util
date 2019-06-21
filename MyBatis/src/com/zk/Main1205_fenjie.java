package com.zk;

import java.io.InputStream;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import com.zk.map.UserMapper;
import com.zk.model.User;

public class Main1205_fenjie {
	
	public static void main(String[] args) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = ClassLoader.getSystemResourceAsStream(resource);
		XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, null, null);
		Configuration config=parser.parse();
		DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(config);
		SqlSession session=sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);//代理模式
			User user = mapper.selectUserById(1l);
			System.err.println(user);
			System.out.println(session.getMapper(UserMapper.class).selectUserById(1l) == user);//缓存
		} finally {
		  session.close();
		}
	}
}