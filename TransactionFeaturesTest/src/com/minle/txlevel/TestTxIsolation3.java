package com.minle.txlevel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTxIsolation3 {
	public static void main(String[] args) {
		/**
		 * 
		 * 不可重复读隔离级别=1,2
		 * 
		 * A事务查询某条记录的某个值，然后B事务修改这个值，A事务查询再一次查询，发现的得到的值已经不是以前那个值，所以叫不可重复读
		 * 
		 * 解决方案：设置隔离级别设为4。8
		 * 
		 * 只要锁定操作的一条记录
		 * 
		 */

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection connA = DriverManager.getConnection(

					"jdbc:mysql://10.0.4.77:3306/demo_ds_0", "root", "123456");

			connA.setAutoCommit(false);// 开启了A事务

			connA.setTransactionIsolation(4);// 设置事务的隔离级别为1，

			// A事务查询数据
			String sqlA = "select money 	from t_order_0 where order_id = '8382454387533415005'";

			PreparedStatement pstmtA = connA.prepareStatement(sqlA);

			ResultSet rs = pstmtA.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getFloat("money"));

			}

			Connection connB = DriverManager.getConnection(

					"jdbc:mysql://10.0.4.77:3306/demo_ds_0", "root", "123456");

			connB.setAutoCommit(false);// 开启了B事务

			String sql = "update t_order_0 set money = 474747 where order_id = '8382454387533415005'";

			PreparedStatement pstmtB = connB.prepareStatement(sql);

			pstmtB.executeUpdate();

			// B事务提交
			connB.commit();

			// connB.close();
//			connB.setAutoCommit(true);// 关闭B事务

			// A事务查询数据
			String sqlA2 = "select money from t_order_0 where order_id = '8382454387533415005'";
			PreparedStatement pstmtA2 = connA.prepareStatement(sqlA2);
			ResultSet rs2 = pstmtA2.executeQuery();
			
			while (rs2.next()) {
				System.out.println(rs2.getFloat("money"));
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
