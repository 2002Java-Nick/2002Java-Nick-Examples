package com.revature.driver;

import java.util.ArrayDeque;
import java.util.Queue;

import com.revature.thread.Consumer;
import com.revature.thread.Producer;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		Producer p = new Producer();
		p.setQueue(q);
		
		Consumer c = new Consumer();
		c.setQueue(q);
		
		new Thread(p).start();
		
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(c).start();
		
	}
	


}
