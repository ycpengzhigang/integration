package com.min.pattern.bridge;

public class Test {
	public static void main(String[] args) {
		Image image;
		ImageImp imp;
		image = (Image) XMLUtil.getBean("images");
		imp = (ImageImp) XMLUtil.getBean("os");
		image.setImp(imp);
		image.parseFile("小龙女");
		
	}
}
