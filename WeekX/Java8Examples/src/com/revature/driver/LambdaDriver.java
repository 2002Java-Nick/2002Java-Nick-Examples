package com.revature.driver;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.revature.domain.User;
import com.revature.lambda.MyFunctionalInterface;

public class LambdaDriver {

	
	/*
	 * Lambda: anonymous function we only use once, and can pass them around our program.  
	 * Syntax: (argumentsNames) -> { //your code here }
	 * You need a functional interface
	 * Functional Interface: an interface with exactly 1 abstract method
	 */
	public static void main(String[] args) {
		
		//Predicate Functional interface: has one abstract method, test
		//returns a boolean, takes a single parameter of an object
		
		User myUser = new User("nick", "1234", "trainer");
		
		System.out.println(viewEmployees(myUser, 
				(user) -> {
					if (user.getUsername().equals("nick") && user.getPassword().equals("1234") && user.getUserType().equals("trainer")) {
						return true;
					} else {
						return false;
					}
				})
				);
		
		System.out.println(viewEmployees(myUser,
				user -> user.getUserType().equals("admin") ? true : false
				));
		
		System.out.println(viewEmployees(myUser,
				(user) -> { return user.getUserType().equals("admin") ? true : false; }
				));
		
		printCost(50, 30, (x, y) -> (x * y));
		
		printCostWithDiscount(34, 88, (x, y) -> x * y);
		
		MyFunctionalInterface<Double> myFunc = (x, y) -> x / (y*2);
		
		myFunc.multiply(4.0, 6.7);
		
	}
	
	private static List<String> viewEmployees(User user, Predicate<User> auth) {
		
		if (auth.test(user)) {
			return Arrays.asList(new String[] {"nick", "david", "chris", "calvin", "mason"});
		} else {
			return null;
		}
		
	}
	
	public static void printCost(int amount, int quantity, MyFunctionalInterface<Integer> multiplier) {
		System.out.println(multiplier.multiply(amount, quantity));
	}
	
	public static void printCostWithDiscount(int amount, int quantity, MyFunctionalInterface<Integer> multiplier) {
		System.out.println(multiplier.discount(50, multiplier.multiply(amount, quantity)));
	}

}
