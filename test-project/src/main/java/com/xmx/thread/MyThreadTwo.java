package com.xmx.thread;

/**
 * 我的线程2——实现Runnable接口
 * @author xmx
 * 2017年4月14日上午11:48:32
 */
public class MyThreadTwo implements Runnable {
	private String name;

	//覆写Thread类中的run方法，这是线程的主体
	public MyThreadTwo(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println("MyThread-->" + name);
	}

}
