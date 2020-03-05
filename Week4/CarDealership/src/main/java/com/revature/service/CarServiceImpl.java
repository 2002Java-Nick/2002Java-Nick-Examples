package com.revature.service;

import java.util.List;

import com.revature.dao.CarDAO;
import com.revature.dao.CarDAOPostgres;
import com.revature.domain.Car;

public class CarServiceImpl implements CarService {
	
	private CarDAO carDao = new CarDAOPostgres();

	public List<Car> getAllCars() {
		return carDao.retrieveAllCars();
	}

	public void addCar(Car car) {
		
	}
	
	public void setCarDao(CarDAO carDao) {
		this.carDao = carDao;
	}

}
