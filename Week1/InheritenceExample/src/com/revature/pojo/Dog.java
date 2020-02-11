package com.revature.pojo;

//POJO - Plain Old Java Object
//had attributes constructor and getters/setters
public class Dog {

	private String breed;

	private String color;

	private int numberOfLegs;

	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Dog)) {
			return false;
		}
		if (!this.breed.equals(((Dog) obj).getBreed())) {
			return false;
		}
		if (!this.color.equals(((Dog) obj).getColor())) {
			return false;
		}
		if (!(this.numberOfLegs == ((Dog)obj).getNumberOfLegs())) {
			return false;
		}
		
		
		return true;
		
	}

	@Override
	public String toString() {
		return "Dog: Breed-" + this.breed + " Color-" + this.color + " Legs-" + this.numberOfLegs;
	}

	public void setColor(String color) {
		// vv-Forces us to refer to instance scope
		this.color = color;

	}

	public String getColor() {
		return this.color;
	}

	public void setBreed(String breed) {
		// vv-Forces us to refer to instance scope
		this.breed = breed;

	}

	public String getBreed() {
		return this.breed;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		// vv-Forces us to refer to instance scope
		if (numberOfLegs < 10 && numberOfLegs >= 0) {
			this.numberOfLegs = numberOfLegs;
		}

	}

	public int getNumberOfLegs() {
		return this.numberOfLegs;
	}

	// default constructor no longer being used
	// no-args constructor we have written
	public Dog() {
		this("lab", "brown", 9);
	}

	public Dog(String breed, String color, int numberOfLegs) {
		setBreed(breed);
		setColor(color);
		setNumberOfLegs(numberOfLegs);
	}

}
