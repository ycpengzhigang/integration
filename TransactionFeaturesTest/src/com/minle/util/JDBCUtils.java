package com.minle.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 原生jdbc的工具类
 * @author Administrator
 *
 */
public final class JDBCUtils {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://192.168.109.128:3306/ds0";
	private static String user = "root";
	private static String password = "pzg131775";

	private JDBCUtils() {
	}

	static {
		/**
		 * 驱动注册
		 */
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}

	}

	/**
	 * 获取 Connetion
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void colseResource(Connection conn, Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConnection(conn);
	}

	/**
	 * 释放连接 Connection
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 等待垃圾回收
		conn = null;
	}

	/**
	 * 释放语句执行者 Statement
	 * 
	 * @param st
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 等待垃圾回收
		st = null;
	}

	/**
	 * 释放结果集 ResultSet
	 * 
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 等待垃圾回收
		rs = null;
	}
	
	/**
	 * 开始事务
	 * @param cnn
	 */
	public static void beginTransaction(Connection cnn){
		if(cnn!=null){
			try {
				if(cnn.getAutoCommit()){
					cnn.setAutoCommit(false);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 提交事务
	 * @param cnn
	 */
	public static void commitTransaction(Connection cnn){
		if(cnn!=null){
			try {
				if(!cnn.getAutoCommit()){
					cnn.commit();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 回滚事务
	 * @param cnn
	 */
	public static void rollBackTransaction(Connection cnn){
		if(cnn!=null){
			try {
				if(!cnn.getAutoCommit()){
					cnn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
}
