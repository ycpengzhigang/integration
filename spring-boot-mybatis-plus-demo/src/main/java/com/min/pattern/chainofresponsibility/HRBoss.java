package com.min.pattern.chainofresponsibility;

public class HRBoss extends Boss{

	public HRBoss(String name, Boss successor) {
		super(name);
		this.successor = successor;
	}

	@Override
	public Boolean PassRequest(Request request) {
		int day = request.getDay();
        String reason = request.getReason();
        
        if (day > 0.5 && day<=2){
        	System.out.println("请假原因:" + reason);
            return true;
        }
        
        return successor.PassRequest(request);
	}

}
