package com.revature.pojo;

//POJO - Plain Old Java Object
//had attributes constructor and getters/setters
public class Dog {

	private String breed;

	private String color;

	private int numberOfLegs;

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

}
