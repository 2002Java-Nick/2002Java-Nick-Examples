package com.revature.driver;

import com.revature.exception.MyCustomException;

public class Driver {

	public static void main(String[] args) { // throws Exception { <--- DO NOT DO THIS, will crash your program

		try {
			throw new Exception();
			// System.out.println("everthing worked"); will never run
		} catch (Exception e) {
			System.out.println("Caught Exception " + e.getClass());
		}

		try {
			willThrow();
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}

		// throw new NullPointerException();

		// Object n = null;

		// n.getClass();

		try {
			mightThrow();
			System.out.println("Exception did not occure in might throw");
		} catch (Exception e) {
			System.out.println("Exception occured in might throw");
		} finally {
			System.out.println("This will always run");
		}

		try {

		} catch (RuntimeException e) {

		} catch (Exception e) {

		} catch (Error e) {

		} catch (Throwable t) {

		} // catch (IOException e) {
			// must be placed before general Exception
			// }

		try {
			throwCustomException();
		} catch (MyCustomException e) {
			System.out.println(e.getMessage());
		}

		try {
		} finally {
		} // try needs at least one catch or finally

		// willNeverThrow(); must be handled even though cannot throw an exception,
		// declares that it will

		System.out.println("Everything is fine");

	}

	public static void willThrow() throws Exception {
		throw new Exception("You knew this would happen.");
	}

	public static void mightThrow() throws Exception {
		if (Math.random() > 0.5) {
			throw new Exception();
		}
	}

	public static void willNeverThrow() throws Exception {
		System.out.println("Everything is ok");
	}

	public static void throwCustomException() throws MyCustomException {
		throw new MyCustomException("This is what happend");
	}

}
