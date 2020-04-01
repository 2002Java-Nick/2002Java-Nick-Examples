package com.revature.thread;

import java.util.Queue;

public class Consumer implements Runnable {
	
	private Queue<Integer> q;
	
	@Override
	public void run() {
		
		for(;;) {
			try {
				int val = q.poll();
				q.remove();
				System.out.println("Reading value " + val);
			} catch (Exception e) {
				System.out.println("Failed in consumer");
				e.printStackTrace();
				System.exit(0);
			}
		}
		
	}
	
	public void setQueue(Queue<Integer> q) {
		this.q = q;
	}

}
