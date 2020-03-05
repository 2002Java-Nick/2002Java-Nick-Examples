package com.revature.dao;

import java.util.List;

import com.revature.domain.Car;
import com.revature.exception.CarInsertionException;

public interface CarDAO {
	
	public List<Car> retrieveAllCars();
	
	public void insertCar(Car car) throws CarInsertionException;

}
