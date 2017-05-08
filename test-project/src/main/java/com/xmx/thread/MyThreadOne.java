package com.xmx.thread;

/**
 * 线程1——继承Thread接口
 * @author xmx 
 * 2017年4月14日上午11:44:48
 */
public class MyThreadOne extends Thread {

	private String name;

	public MyThreadOne(String name) {
        this.name = name;
    }

	public void run() {// 覆写Thread类中的run方法
		System.out.println("MyThread——>" + name);
	}
}
