package com.xmx.test;

import java.util.concurrent.CountDownLatch;

public class User implements Runnable {
	private CountDownLatch end;
	private int sum;

	public CountDownLatch getEnd() {
		return end;
	}

	public void setEnd(CountDownLatch end) {
		this.end = end;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public User(CountDownLatch end, int sum) {
		this.end = end;
		this.sum = sum;
	}

	public void run() {
		try {
			doChange();
		} catch (Exception e) {
		}
	}

	public void doChange() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i+"*********************");
			this.sum++;
		}
	}
}
