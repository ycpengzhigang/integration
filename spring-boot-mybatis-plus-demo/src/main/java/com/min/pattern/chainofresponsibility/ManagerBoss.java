package com.min.pattern.chainofresponsibility;

public class ManagerBoss extends Boss {

	public ManagerBoss(String name, Boss successor) {
		super(name);
		this.successor = successor;
	}

	@Override
	public Boolean PassRequest(Request request) {
		int day = request.getDay();
		String reason = request.getReason();
		
		if (reason.equals("正当理由")) {
			System.out.println("请加天数:" + day);
			return true;
		}
		
		return false;
	}

}
