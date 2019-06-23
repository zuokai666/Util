package com.zk.Test.lock;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zk.model.User;

public class Main0102 {
	
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
		User user=new User();
		user.setAccount("root1");
		
		SqlSession session1=sqlSessionFactory.openSession();
		SqlSession session2=sqlSessionFactory.openSession();
		
		User user1 = session1.selectOne("selectUserByParms", user);
		User user2 = session2.selectOne("selectUserByParms", user);
		System.err.println("原始数据："+user2.toString());
		user1.setName(new Date().toString());
		Thread.sleep(1500);
//		user2.setName(new Date().toString());
		
		@SuppressWarnings("unused")
		int u1=session1.update("updateUser", user1);
		System.err.println("s1已经改为："+session1.selectOne("selectUserByParms", user).toString());
		session1.commit();
		session1.close();
		
		System.err.println("测试不可重复读2："+session2.selectOne("selectUserByParms", user).toString());
//		int u2=session2.update("updateUser", user2);
		session2.commit();
		session2.close();
//		System.err.println("u1="+u1+",u2="+u2);
		
		
		
	}
	
	public static void zhijiefanhui(String[] args) throws Exception {
		User user=new User();
		user.setAccount("root1");
		
		SqlSession session1=sqlSessionFactory.openSession();
		SqlSession session2=sqlSessionFactory.openSession();
		
		User user1 = session1.selectOne("selectUserByParms", user);
		User user2 = session2.selectOne("selectUserByParms", user);
		user1.setName(new Date().toString());
		Thread.sleep(1500);
		user2.setName(new Date().toString());
		
		int u1=session1.update("updateUser", user1);
		session1.commit();
		session1.close();
		
		int u2=session2.update("updateUser", user2);
		if(u2 == 0){
			throw new RuntimeException("Row was updated or deleted by another transaction");
		}
		session2.commit();
		session2.close();
		System.err.println("u1="+u1+",u2="+u2);		
	}
	
	public static int fun() {
		User user=new User();
		user.setAccount("root1");
		SqlSession session2=sqlSessionFactory.openSession();
		User user2 = session2.selectOne("selectUserByParms", user);
		user2.setName(new Date().toString());
		int res=session2.update("updateUser", user2);
		session2.commit();
		session2.close();
		return res;
	}
	
	private static final Logger log=LoggerFactory.getLogger(Main0102.class);
	
	public static void main(String[] args) throws Exception {
		ExecutorService executor=Executors.newCachedThreadPool();
		for(int i=0;i<20;i++){
			executor.execute(()->{
				int res=fun();
				while(res == 0){
					res=fun();
				}
				log.info("更新"+(res == 0?"失败":"成功"));
			});
		}
	}
}