package com.min.pattern.chainofresponsibility;

public abstract class Boss {
    private String name;
    
    protected Boss successor;
    

	public Boss(String name) {
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return  name;
	}
	
	public abstract Boolean PassRequest(Request request);
    
    
}
