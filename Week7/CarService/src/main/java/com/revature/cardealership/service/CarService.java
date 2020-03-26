package com.revature.cardealership.service;

import java.util.List;

import com.revature.cardealership.domain.Car;

public interface CarService {

	public List<Car> getAllCars();
	
	public Car getCarByVin(String vin);
	
	public void addCar(Car car);
	
	public void removeCar(String vin);
	
	public void updateCar(Car car);
	
}
