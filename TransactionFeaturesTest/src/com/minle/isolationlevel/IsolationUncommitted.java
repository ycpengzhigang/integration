package com.minle.isolationlevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.minle.util.JDBCUtils;

/**
 * 隔离级别为
 * 脏读：
 *（针对未提交数据）如果一个事务中对数据进行了更新，但事务还没有提交，
 * 另一个事务可以“看到”该事务没有提交的更新结果，这样造成的问题就是，
 * 如果第一个事务回滚，那么，第二个事务在此之前所“看到”的数据就是一笔脏数据。
 * 导致的问题:脏读,幻读,不可重复读(同一个事物内两次读取的数据不一致)
 * 
 * 不可重复读：
 *  （针对其他提交前后，读取数据本身的对比）不可重复读取是指同一个事务在整个事务过程中对同一笔数据进行读取，
 *  每次读取结果都不同。如果事务1在事务2的更新操作之前读取一次数据，
 *  在事务2的更新操作之后再读取同一笔数据一次，两次结果是不同的，
 *  所以，Read Uncommitted也无法避免不可重复读取的问题。
 *  
 *  幻读:
 *  （针对其他提交前后，读取数据条数的对比） 幻读是指同样一笔查询在整个事务过程中多次执行后，查询所得的结果集是不一样的。
 *  幻读针对的是多笔记录。
 *  在Read Uncommitted隔离级别下， 不管事务2的插入操作是否提交，
 *  事务1在插入操作之前和之后执行相同的查询，取得的结果集是不同的，所以，Read Uncommitted同样无法避免幻读的问题。
 *  
 *  
 * 1、read-uncommitted 验证 
 * 
 */
public class IsolationUncommitted {
	
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				testCommitAfterMills();
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				testReadUncommit();
			}
		}).start();
	}
	
	public static void testReadUncommit() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 获取连接
			conn = JDBCUtils.getConnection();
			// 一定要在开启事务前设置隔离级别，否则无效
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("select * from account where name='aaa'");
			rs = stmt.executeQuery();
//			System.out.println("结束时的余额："+rs.getString("money"));
//			rs.last();
//			System.out.println("aaa的数量:"+rs.getInt(1));
//			for (int i = 0; i < 10; i++) {
							while(rs.next()){
								System.out.println("开始时的余额："+rs.getString("money"));
							}
//				stmt = conn.prepareStatement("select * from account where name='aaa'");
//				rs = stmt.executeQuery();
//				rs.last();
//				System.out.println("aaa的数量:" + rs.getInt(1));
//				Thread.sleep(1000);
//			}
			while(rs.next()){
				System.out.println("结束时的余额："+rs.getString("money"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	
	public static void testCommitAfterMills(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 获取连接
			conn = JDBCUtils.getConnection();
			// 一定要在开启事务前设置隔离级别，否则无效
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			conn.setAutoCommit(false);
//			stmt = conn.prepareStatement("select * from account where name='aaa'");
//			rs = stmt.executeQuery();
			
//			while(rs.next()){
//				System.out.println("开始时的余额："+rs.getString("money"));
//			}
//			
			String sql = "update account set money = ? where name = ?";
//			
//			// 创建执行语句
			stmt = conn.prepareStatement(sql);
			stmt.setFloat(1, 5000);
			stmt.setString(2, "aaa");
			
			// 执行sql
            int i = stmt.executeUpdate();
            // 睡眠10s
         	Thread.sleep(3*1000);

         	String str = null;
         	str.length();
         	
//            if(i==1) {
//                System.out.println("数据添加成功！");
//            }else {
//                System.out.println("数据添加失败！");
//            }

//			for (int i = 0; i < 3; i++) {
//				// 编写sql
//				String sql = "insert into account(name,money) values (?,?)";
//				// 创建语句执行者
//				stmt = conn.prepareStatement(sql);
//				// 设置参数
//				stmt.setString(1, "aaa");
//				stmt.setFloat(2, 2000);
//				stmt.executeUpdate();
//				Thread.sleep(2000);
//			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	
	
	
	
	
	
	
	
}
