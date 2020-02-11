package com.revature.driver;

import com.revature.pojo.Dog;
import com.revature.pojo.GermanShephardMiniature;

public class DogDriver {

	public static void main(String[] args) {
		com.revature.pojo.Dog d1 = new Dog("Snoop", "Blue", 2);

		/*
		 * d1.setBreed("Snoop"); d1.setColor("Blue"); d1.setNumberOfLegs(2);
		 */

		System.out.println("Dog Breed: " + d1.getBreed());
		System.out.println("Dog Color: " + d1.getColor());
		System.out.println("Dog Legs: " + d1.getNumberOfLegs());

		Dog d2 = new GermanShephardMiniature();

		// d2.setBreed("German Shephard");
		d2.setColor("Blue");
		d2.setNumberOfLegs(5);

		System.out.println("Dog Breed: " + d2.getBreed());
		System.out.println("Dog Color: " + d2.getColor());
		System.out.println("Dog Legs: " + d2.getNumberOfLegs());
		if (d2 instanceof GermanShephardMiniature) {
			System.out.println("Dog has pointy ears? " + ((GermanShephardMiniature) d2).getPointyEars());
		}
		
		GermanShephardMiniature g1 = (GermanShephardMiniature) d2;
		
		System.out.println("Test 1: " + new Dog("breed", "color", 1).equals(new Dog("breed", "color", 1)));
		System.out.println("Test 2: " + new Dog("breed", "color", 1).equals(new Dog("breed", "color", 4)));
		System.out.println(new Dog("test breed", "test Color", 5));
		

	}

}
