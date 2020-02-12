package com.revature.util;

public class CalcImpl <T extends Number> implements Calculator<T>{

	@Override
	public T add(T x, T y) {

		Number ret = x.intValue() + y.intValue();
		
		
		return (T) ret;
	}

	@Override
	public T sub(T x, T y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T div(T x, T y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T mult(T x, T y) {
		// TODO Auto-generated method stub
		return null;
	}
}
