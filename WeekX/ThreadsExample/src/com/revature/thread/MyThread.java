package com.revature.thread;

public class MyThread extends Thread {
	
	public String name;
	
	@Override
	public void run() {
		for (int i = 1; i < 10001; i++) {
			System.out.println("Inside MyThread " + name + ": " + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
