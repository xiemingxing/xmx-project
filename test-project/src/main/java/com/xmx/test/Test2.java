package com.xmx.test;

import java.util.concurrent.CountDownLatch;

public class Test2 {

	public static void main(String[] args) throws InterruptedException{
		//线程通信计数器  
        CountDownLatch end = new CountDownLatch(0);  
		User user = new User(end, 0);
		Thread thread = new Thread(user);
		thread.start();
		end.await(100L, null);
		System.out.println("总数："+user.getSum()+"~~~~~~~~~~~~~~~~~~~~~~~");
		
	}

}
