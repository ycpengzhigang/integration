package com.min.pattern.listener1;

/**
 * 事件对象 包含了事件源 也就是事件的触发了一个什么事件
 * 
 * @author PENGZHIGANG 2018/9/26
 *
 */
public class Event {
	
	/**
	 * 事件源
	 */
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
}
