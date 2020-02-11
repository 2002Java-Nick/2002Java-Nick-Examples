package com.revature.pojo;

public class GermanShephardMiniature extends Dog {
	
	private final boolean POINTY_EARS = true;
	
	public boolean getPointyEars() {
		return this.POINTY_EARS;
	}
	
	public GermanShephardMiniature() {
		setBreed("German Shephard");
	}

}
