package com.min.pattern.listener2;

import java.util.EventObject;
/**
 * 定义事件对象,将事件源进行包装
 * @author Administrator
 *
 */
public class DemoEvent extends EventObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2701003433452370973L;
	
	/**
	 * 通过构造器将对象事件源传入
	 * @param source
	 */
	public DemoEvent(Object source) {
		super(source);
	}

	public void say(){
		System.out.println("this is a say method");
	}
	
}
