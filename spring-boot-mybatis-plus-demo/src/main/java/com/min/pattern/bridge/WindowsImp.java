package com.min.pattern.bridge;

public class WindowsImp implements ImageImp {

	@Override
	public void doPaint(Matrix m) {
		System.out.println("调用windows系统显示像素矩阵");
	}

}
