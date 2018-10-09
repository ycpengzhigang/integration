package com.min.pattern.listener1;

/**
 * 监听器
 * 
 * @author PENGZHIGANG 2018/9/26
 *
 */
public interface Listener {
	
	/**
	 * 监听事件  接受一个事件对象
	 * @param event
	 */
	void isReading(Event event);
}
