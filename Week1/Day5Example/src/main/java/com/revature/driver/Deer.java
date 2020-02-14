package com.revature.driver;

public class Deer {
	
	private String name;
	
	public Deer(String name) {
		this.name = name;
		System.out.println("Creating deer " + this.name);

	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("'I am dying now'-"+this.name);
	}



	@Override
	public String toString() {
		return "Deer [name=" + name + "]";
	}

}
