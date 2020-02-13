package com.revature.util;

import com.revature.exception.SumTooLargeException;

public class CalcImpl <T extends Number> implements Calculator<T>{

	@Override
	public T add(T x, T y) {

		if (y.intValue() > (Integer.MAX_VALUE - x.intValue())) {
			throw new SumTooLargeException();
		}
		
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
