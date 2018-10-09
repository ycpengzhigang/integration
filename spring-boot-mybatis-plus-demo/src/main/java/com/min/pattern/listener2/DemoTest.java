package com.min.pattern.listener2;

public class DemoTest {
	private DemoSource ds;
	
	public DemoTest(){
		ds = new DemoSource();
		// 将事件监听器加入到
		DemoListener1 demoListener1 = new DemoListener1();
		ds.addDemoListener(demoListener1);
		ds.addDemoListener(new DemoListener(){
			@Override
			public void handleEvent(DemoEvent dm) {
				System.out.println("Method come from 匿名类...");
				
			}});
		 ds.notifyDemoEvent();//触发事件、通知监听器   
	}

	public static void main(String[] args) {
		new DemoTest();     
	}
	
}
