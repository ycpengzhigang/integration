package com.min.pattern.listener2;

public class DemoListener1 implements DemoListener {

	@Override
	public void handleEvent(DemoEvent dm) {
		 System.out.println("Inside listener1...");     
		 dm.say();//回调 
	}

}
