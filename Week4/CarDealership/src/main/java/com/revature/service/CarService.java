package com.revature.service;

import java.util.List;

import com.revature.domain.Car;

public interface CarService {
	
	public List<Car> getAllCars();
	
	public void addCar(Car car);

}
