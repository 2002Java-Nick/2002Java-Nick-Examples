package com.revature.util;

public interface Calculator <T extends Number> {

	public T add(T x, T y);
	
	public T sub(T x, T y);
	
	public T div(T x, T y);
	
	public T mult(T x, T y);
	
}
