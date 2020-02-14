package com.revature.driver;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionsDriver {
	
	public static void main(String[] args) {
		
		List<Double> doubleList = new LinkedList<Double>(); 
		
		//Autoboxing - Java automatically wraps our primatives
		//into a Wrapper class object when it expects an
		//object instead of a primative.
		doubleList.add(45.6);
		doubleList.add(7.69);
		doubleList.add(234.6908);
		doubleList.add(848.34);
		doubleList.add(5.2384);
		
		//Autounboxing - the reverse process
		System.out.println(add(doubleList.get(1), doubleList.get(4)));
		
		//Iterable is the parent interface of Collection
		Iterator<Double> i = doubleList.iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		Collections.sort(doubleList);
		
		System.out.println("Sorting.....");
		
		i = doubleList.iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		//Map - key value pair
		Map<Integer, String> exampleMap = new HashMap<Integer,String>();
		exampleMap.put(27, "stuff");
		exampleMap.get(27);
		
		//Iterator i = exampleMap.iterator(); map is not iterable
		
		/*
		 * for (Integer i: exampleMap) {
		 * 
		 * }
		 */
		
	}
	
	public static double add(double x, double y) {
		return x + y;
	}

}
