package com.minle.isolationlevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.minle.util.JDBCUtils;

public class IsolationRepeatableRead extends Isolation {
	public static void main(String[] args) {
		// 先验证级别RepeatableRead解决的脏读和重复读带来的问题
		new Thread(new Runnable() {
			@Override
			public void run() {
				SecondTransactionBegin();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				FirstTransactionBegin();
			}
		}).start();
	}

	public static void FirstTransactionBegin() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			Thread.sleep(5 * 1000);
			String sql = "select * from account where name= ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "bbb");
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("money"));
			}
			Thread.sleep(5 * 1000);
			String sql1 = "select * from account where name= ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "bbb");
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("money"));
			}
		} catch (Exception e) {
			rollBackTransaction(conn);
			e.printStackTrace();
		} finally {
			commitTransaction(conn);
		}

	}

	public static void SecondTransactionBegin() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			String sql = "update account set money = ? where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setFloat(1, 5555);
			ps.setString(2, "bbb");
			int ret = ps.executeUpdate();

			Thread.sleep(5 * 1000);

			String sql1 = "update account set money = ? where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setFloat(1, 6666);
			ps.setString(2, "bbb");
			int ret1 = ps.executeUpdate();
		} catch (Exception e) {
			rollBackTransaction(conn);
			e.printStackTrace();
		} finally {
			commitTransaction(conn);
		}

	}

}
