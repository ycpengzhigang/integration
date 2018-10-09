package com.min.pattern.bridge;

public abstract class Image {
	
	protected ImageImp imp;
	
	public void setImp(ImageImp imp){
		this.imp = imp;
	}
	
	public abstract void parseFile(String fileName); 
	
}
