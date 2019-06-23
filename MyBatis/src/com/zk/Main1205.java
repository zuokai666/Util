package com.zk;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zk.map.UserMapper;
import com.zk.model.User;

public class Main1205 {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static{
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static void main1(String[] args) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);//代理模式
			User user=new User();
			List<User> users = mapper.selectUserByParms(user);
			System.err.println(users);
		} finally {
		  session.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		try {
			User user=new User();
//			user.setAccount("root1");
			user.setPassword("123");
			List<User> users = session.selectList("com.zk.map.UserMapper.selectUserByParms1", user, new RowBounds(1, 1));
			System.err.println(users);
		} finally {
		  session.close();
		}
	}
}