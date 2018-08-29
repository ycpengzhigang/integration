package com.minle.txlevel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTxIsolation2 {
	public static void main(String[] args) {

		/**
		 * 
		 * 幻读：如果隔离级别设为1、2
		 * 
		 * A事务对表进行某种条件的查询操作，这时B事务插入或者删除符合某种条件的操作，A事务对表进行再次查询同样的操作，发现前后两次的结果不一样
		 * 
		 * 解决方案：设置隔离级别设为4、8
		 * 
		 * 只要锁定整张表
		 * 
		 */

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connA = DriverManager.getConnection("jdbc:mysql://10.0.4.77:3306/demo_ds_0", "root", "123456");
			
			// 开启了A事务
			connA.setAutoCommit(false);
			// 设置事务的隔离级别为1或2，会出现幻读
			connA.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

			// A事务查询数据
			String sqlA = "select * from t_order_0";
			PreparedStatement pstmtA = connA.prepareStatement(sqlA);
			ResultSet rs = pstmtA.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("user_id") + "  " + rs.getFloat("money"));
			}

			Connection connB = DriverManager.getConnection(
					"jdbc:mysql://10.0.4.77:3306/demo_ds_0", "root", "123456");
			connB.setAutoCommit(false);// 开启了B事务

			String sql = "insert into t_order_0(user_id,status,money) values('49','insert',4848)";
			PreparedStatement pstmtB = connB.prepareStatement(sql);
			pstmtB.executeUpdate();

			// B事务提交
			connB.commit();
			connB.setAutoCommit(true);// 关闭B事务

			// A事务再次查询数据
			String sqlA2 = "select * from t_order_0";
			PreparedStatement pstmtA2 = connA.prepareStatement(sqlA2);
			ResultSet rs2 = pstmtA2.executeQuery();
			
			System.out.println("=======");

			while (rs2.next()) {
				System.out.println(rs2.getInt("user_id") + "  " + rs2.getString("money"));
			}

			connB.setAutoCommit(true);// 关闭B事务
			connA.setAutoCommit(true);// 关闭A事务
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
