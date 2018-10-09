package com.min.pattern.listener1;

/**
 * 事件源 拥有一个监听器
 * 
 * @author PENGZHIGANG 2018/9/26
 *
 */
public class Student {

	/**
	 *  监听器
	 */
	private Listener listener;
	
	private String name;
	
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public Listener getListener() {
		return listener;
	}

	public void setListener(Listener listener) {
		this.listener = listener;
	}

	public void read(){  // 事件触发点
		Event event = new Event(); 
		event.setStudent(this);
		listener.isReading(event);
		
	}
	
	
	
}
