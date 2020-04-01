package com.revature.thread;

import java.util.Queue;

public class Producer implements Runnable {

	private Queue<Integer> q;
	
	@Override
	public void run() {

		int value = 0;
		
		for(;;) {
			System.out.println("adding value " + value);
			q.add(value++);
		}
		
	}
	
	public void setQueue(Queue<Integer> q) {
		this.q = q;
	}

}
