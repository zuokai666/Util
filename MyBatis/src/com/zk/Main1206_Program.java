package com.zk;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.zk.map.UserMapper;
import com.zk.model.User;

public class Main1206_Program {
	
	public static void main(String[] args) throws Exception {
		DataSource dataSource=new PooledDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","d2p9bupt");
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(UserMapper.class);
		SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
		SqlSession session=sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);//代理模式
			User user = mapper.selectUserById(1l);
			System.err.println(user);
			System.out.println(session.getMapper(UserMapper.class).selectUserById(1l) == user);//缓存
		} finally {
			session.close();//将资源归还数据库连接池
		}
	}
}