package com.xmx.thread;

/**
 * 线程测试类
 * @author xmx
 * 2017年4月14日上午11:47:00
 */
public class Test {

	public static void main(String args[]) {
		MyThreadOne t1 = new MyThreadOne("线程1");
		MyThreadOne t2 = new MyThreadOne("线程2");
		t1.start();// 调用线程启动方法
		t2.start();// 调用线程启动方法
		System.out.println("*****************************************");
		MyThreadTwo t = new MyThreadTwo("线程");
	    new Thread(t).start();
	    new Thread(t).start();
	}
}
