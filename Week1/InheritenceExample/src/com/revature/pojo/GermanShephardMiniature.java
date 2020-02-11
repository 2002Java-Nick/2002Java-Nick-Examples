package com.revature.pojo;

public class GermanShephardMiniature extends Dog {
	
	private final boolean POINTY_EARS = true;
	
	public boolean getPointyEars() {
		return this.POINTY_EARS;
	}
	
	//annotation - passes some metadata to the class, could give additional functionality
	@Override
	public void setColor(String color) {
		
		switch (color) {
		
		case "black": {
			super.setColor(color);
			break;
		}
		
		case "brown": {
			super.setColor(color);
			break;
		}
		
		case "white": {
			super.setColor(color);
			break;
		}
		default: {
			super.setColor("This is a ridiculous color for German Shephard, I don't accept it");
			break;
		}
		}
		
	}
	
	public GermanShephardMiniature() {
		//super() - implicit
		setBreed("German Shephard");
	}
	
	public GermanShephardMiniature(String color, int numberOfLegs) {
		this();
		setColor(color);
		setNumberOfLegs(numberOfLegs);
		//super(); - must be first line
		
	}

}
