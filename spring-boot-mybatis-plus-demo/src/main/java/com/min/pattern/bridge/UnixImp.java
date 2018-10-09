package com.min.pattern.bridge;

public class UnixImp implements ImageImp {

	@Override
	public void doPaint(Matrix m) {
		System.out.println("使用Unix显示图像");
	}

}
