package com.source.module.datasource.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceTest {
	
	private static final Logger log=LoggerFactory.getLogger(DataSourceTest.class);
	
	static DataSource dataSource;
	
	static{
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
	    String username = "root";
	    String password = "d2p9bupt";
//	    DruidDataSource dataSource1=new DruidDataSource();
//		dataSource1.setDriverClassName(driverClassName);
//		dataSource1.setUrl(url);
//		dataSource1.setPassword(password);
//		dataSource1.setUsername(username);
//		dataSource1.setMinIdle(1);
//		dataSource1.setMaxActive(2);
	    
	    UnpooledDataSource dataSource1=new UnpooledDataSource();
		dataSource1.setDriver(driverClassName);
		dataSource1.setUrl(url);
		dataSource1.setPassword(password);
		dataSource1.setUsername(username);
		dataSource=dataSource1;
	}
	
	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			try {
				executor.execute(()->{select();});
			} catch (RejectedExecutionException e) {
				System.err.println("线程池拒绝提供服务");
			}
		}
		executor.shutdown();
	}
	
	private static void select() {
		JdbcTransaction transaction=new JdbcTransaction(getConn2());
	    String sql = "select * from User where password = ?";
	    PreparedStatement pstmt;
	    try {
	        pstmt = transaction.getConnection().prepareStatement(sql);
	        pstmt.setString(1, "123");
	        pstmt.execute();
	        log.info(transaction.getConnection().toString());
	        transaction.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static Connection getConn2() {
	    Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return conn;
	}
}