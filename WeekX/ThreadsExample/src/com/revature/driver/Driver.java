package com.revature.driver;

import com.revature.thread.MyRunnable;
import com.revature.thread.MyThread;

public class Driver {

	public static void main(String[] args) {

		MyThread t = new MyThread();

		t.name = "t1";

		t.start();

		MyThread t2 = new MyThread();

		t2.name = "t2";

		t2.start();

		MyRunnable r = new MyRunnable();

		r.name = "r1";

		Thread t3 = new Thread(r);

		t3.start();

		Thread t4 = new Thread(() -> {
			for (int i = 1; i < 10001; i++) {
				System.out.println("Inside MyThread a Lambda: " + i);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t4.start();
	}

}
