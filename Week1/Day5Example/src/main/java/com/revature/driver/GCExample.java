package com.revature.driver;

public class GCExample {

	public static void main(String[] args) {
		
		for (int i = 0; i < 1000000; i++) {
			new Deer("Deer#"+(i+1));
			//System.gc();
		}
		
	}

}
