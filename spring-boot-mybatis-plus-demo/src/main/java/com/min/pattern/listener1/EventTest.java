package com.min.pattern.listener1;

public class EventTest {

	public static void main(String[] args) {
		ReadListener readListener = new ReadListener();
		Student student = new Student();
		student.setListener(readListener);
		// 当执行这个方法时，会自动调用ReadListener.isReading()方法
		student.read();

	}
}
