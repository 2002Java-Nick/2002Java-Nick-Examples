package com.revature.service;

import java.util.List;

import com.revature.domain.Car;
import com.revature.domain.User;

public interface CarService {
	
	public void insertCar(Car car);
	
	public Car getCarByVin(String vin);
	
	public List<Car> getAllCars();
	
	public void updateCar(Car car);
	
	public void deleteCar(String vin);
	
	public List<Car> getCarsByOwner(String username);

}
