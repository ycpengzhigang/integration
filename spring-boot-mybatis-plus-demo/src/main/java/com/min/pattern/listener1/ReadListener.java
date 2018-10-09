package com.min.pattern.listener1;
/**
 *  读监听器
 * @author PENGZHIGANG 2018/9/26
 *
 */
public class ReadListener implements Listener {

	@Override
	public void isReading(Event event) {
	    /**
         * 使用 event.getStudent()方法获取事件源的引用，然后执行相关操作
         */
		// 获取事件源
		Student student = event.getStudent();
		System.out.println(student);
        System.out.println(student.getName()+"正在读书...");
        
	}

}
