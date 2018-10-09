package com.min.pattern.bridge;

public class GIFImage extends Image {

	@Override
	public void parseFile(String fileName) {
		Matrix m = new Matrix();
		imp.doPaint(m);
		System.out.println(fileName + "，格式为GIF。");
	}

}
