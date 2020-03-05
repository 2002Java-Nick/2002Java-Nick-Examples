package com.revature.service;

import java.util.List;

import com.revature.domain.Car;
import com.revature.exception.CarInsertionException;

public interface CarService {
	
	public List<Car> getAllCars();
	
	public void addCar(Car car) throws CarInsertionException;

}
