package com.revature.lambda;

@FunctionalInterface
public interface MyFunctionalInterface<T extends Number> {
	
	public T multiply(T x, T y);
	
	public default Integer discount(Integer percent, Integer total) {
		return total * (100 - percent)/100;
	}
	
}
