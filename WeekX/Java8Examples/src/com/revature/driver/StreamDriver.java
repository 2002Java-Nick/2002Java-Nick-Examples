package com.revature.driver;

import java.util.Arrays;

public class StreamDriver {

	public static void main(String[] args) {

		int[] iArr = {234, 34, 3, 509, 5432, 1, 349523, -234, 99, 2, 102342, 8};
		
		System.out.println("Entire []: " + Arrays.toString(iArr));
		
		int[] plus2 = Arrays.stream(iArr).map((x) -> x + 2).toArray();
		
		System.out.println("[] + 2" + Arrays.toString(plus2));
		
		int[] narrow = Arrays.stream(iArr).filter((x) -> x < 100).filter((x) -> x > 0).toArray();
		
		System.out.println("narrowed []" + Arrays.toString(narrow));
		
		int differenceOfEvensAndOdds = Arrays.stream(iArr).map(x -> (x%2==0)? 1 : -1).sum();
		
		System.out.println("Number of Evens: " + Arrays.stream(iArr).filter(x -> x%2==0).toArray().length);
		
		System.out.println("Number of Odds: " + Arrays.stream(iArr).filter(x -> x%2!=0).toArray().length);
		
		System.out.println("difference: " + differenceOfEvensAndOdds);
		
		
	}

}
