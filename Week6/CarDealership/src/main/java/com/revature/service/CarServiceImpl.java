package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CarDAO;
import com.revature.domain.Car;
import com.revature.exception.CarInsertionException;

@Service
public class CarServiceImpl implements CarService {
	
	//@Autowired - Not Best Practice (Field level injection)
	private CarDAO carDao;

	public List<Car> getAllCars() {
		return carDao.retrieveAllCars();
	}

	public void addCar(Car car) throws CarInsertionException {
		carDao.insertCar(car);
	}
	
	//@Autowired
	public CarServiceImpl(CarDAO carDao) {
		this.carDao = carDao;
	}
	
	@Autowired
	public void setCarDao(CarDAO carDao) {
		this.carDao = carDao;
	}

	public Car getCar(String vin) {
		return carDao.retriveCarByVin(vin);
	}

	public CarServiceImpl () {
		
	}
	
}
