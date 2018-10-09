package com.min.pattern.bridge;

public class LinuxImp implements ImageImp {

	@Override
	public void doPaint(Matrix m) {
		System.out.println("使用linux系统显示图像");
	}

}
