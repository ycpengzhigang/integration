package com.minle.txlevel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTxIsolation {
	public static void main(String[] args) {
		/**
		 * 
		 * 脏读：把隔离级别设为1
		 * 
		 * 一个A事务读取另一个B事务没有提交的数据，说明库里还没有改数据，但是A事务已经查询出该数据，没有和数据库保持一致，
		 * 
		 */

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connA = DriverManager.getConnection(
					"jdbc:mysql://10.0.4.77:3306/demo_ds_0", "root", "123456");
			connA.setTransactionIsolation(2);// 设置事务的隔离级别为1，说明可以读取没有提交的数据
			connA.setAutoCommit(false);// 开启了A事务
			Connection connB = DriverManager.getConnection(
					"jdbc:mysql://10.0.4.77:3306/demo_ds_0", "root", "123456");
			connB.setAutoCommit(false);// 开启了B事务
			String sql = "insert into t_order_0(user_id, status, money) values (?,?,?)";
			PreparedStatement ps = connB.prepareStatement(sql);
			ps.setInt(1, 2223);
			ps.setString(2, "insert");
			ps.setFloat(3, 1000);
			ps.executeUpdate();
			// B事务没有提交
			// connB.commit();
			// A事务查询数据
			String sqlA = "select * from t_order_0 where user_id = ?";
			PreparedStatement pstmtA = connA.prepareStatement(sqlA);
			pstmtA.setInt(1, 2223);
			ResultSet rs = pstmtA.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("user_id") + "  "
						+ rs.getString("money"));
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
