package com.revature.driver;

//Overloading - methods with the same name but different parameters
//Form of Polymorphism
public class Driver {

	public static void main(String[] args) {

		Driver d = new Driver();
		
		System.out.println(d.add(12, 33));
		
		System.out.println(d.add(12, 33, 397));
		
		System.out.println(d.add(12.6, 33));
		
		System.out.println(d.add(12, 33, 4, 6, 243, 734, 342, 67, 12, 7835, 43, 6, 23 , 457));
		
		System.out.println(d.add(3));
		
	}
	
	//Var-args: variable length arguments
	//must be the last argument
	//only one per method
	public int add (double y, int ... x) {
		
		System.out.println("Inside var args");
		
		int result = (int)y;
		
		for (int i : x) {
			result += i;
		}
		
		return result;
	}
	
	public int add(int x, int y) {
		System.out.println("inside 2 param");
		return x + y;
	}
	
	public int add(int x, int y, int z) {
		return x + y + z;
	}
	
	public int add(double x, int y) {
		return (int)x + y;
	}

}
