package com.min.pattern.listener2;

import java.util.Enumeration;
import java.util.EventListener;
import java.util.Vector;
/**
 * 事件源
 * @author PENGZHIGANG
 *
 */
public class DemoSource {

	/**
	 * 监听自己的监听器队列
	 */
	private Vector<EventListener> repository = new Vector<EventListener>();

	public DemoSource() {}

	/**
	 * 添加事件监听器
	 * @param dl
	 */
	public void addDemoListener(DemoListener dl) {
		repository.addElement(dl);
	}
	
	/**
	 * 通知所有的事件监听器
	 */
	public void notifyDemoEvent(){
		Enumeration<EventListener> eventListeners = repository.elements();
		
		while (eventListeners.hasMoreElements()) {
			DemoListener eventListener = (DemoListener)eventListeners.nextElement();
			eventListener.handleEvent(new DemoEvent(this));
		}
	}
	
}
