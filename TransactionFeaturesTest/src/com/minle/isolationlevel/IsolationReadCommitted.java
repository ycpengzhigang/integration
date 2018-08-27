package com.minle.isolationlevel;
/**
 * 验证隔离级别ReadCommit
 *  可以阻止脏读，不可以阻止幻读(主要是针对结果集)和不可重复读(在同一个事物多次读取同一个数据)
 */
public class IsolationReadCommitted extends Isolation{
	
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {

			}
		}).start();
	}
	
	
}
