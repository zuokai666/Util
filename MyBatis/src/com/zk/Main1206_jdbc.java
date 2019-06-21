package com.zk;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import com.alibaba.druid.pool.DruidDataSource;

public class Main1206_jdbc {
	
	public static Connection getConn() {
	    String url = "jdbc:mysql://localhost:3306/test";
	    String username = "root";
	    String password = "d2p9bupt";
	    Connection conn = null;
	    try {
	    	DriverManager.setLogWriter(new PrintWriter(System.out));
	        conn = DriverManager.getConnection(url, username, password);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	public static Connection getConn1() {
		PooledDataSource dataSource=new PooledDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","d2p9bupt");
	    Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return conn;
	}
	
	@SuppressWarnings("resource")
	public static Connection getConn2() {
		String url = "jdbc:mysql://localhost:3306/test";
	    String username = "root";
	    String password = "d2p9bupt";
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setPassword(password);
		dataSource.setUsername(username);
	    Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return conn;
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn = getConn();
	    String sql = "select * from User where password = ?";
	    PreparedStatement pstmt;
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "123");
	        pstmt.execute();
	        ResultSet rs = pstmt.getResultSet();
	        while (rs.next()) {
	            System.err.println(rs.getString("account")+"-"+rs.getString("password"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}