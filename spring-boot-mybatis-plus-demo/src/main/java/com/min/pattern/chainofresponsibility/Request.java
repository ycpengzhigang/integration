package com.min.pattern.chainofresponsibility;

public class Request {
	private int day;
	
	private String reason;

	public Request(int day, String reason) {
		this.day = day;
		this.reason = reason;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	public int getDay(){
		return  day;
	}
	
	public String getReason(){
		return reason;
	}
	
	public void setReason(String reason){
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Request [day=" + day + ", reason=" + reason + "]";
	}
	
}
