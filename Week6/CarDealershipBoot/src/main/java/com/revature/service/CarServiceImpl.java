package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.domain.Car;
import com.revature.repository.CarRepository;
import com.revature.repository.UserRepository;

@Service
public class CarServiceImpl implements CarService {
	
	private CarRepository carRepository;
	
	private UserRepository userRepository;
	
	@Autowired
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void insertCar(Car car) {
		carRepository.save(car);
	}

	@Override
	public Car getCarByVin(String vin) {
		return carRepository.getOne(vin);
	}

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public void updateCar(Car car) {
		carRepository.save(car);
	}

	@Override
	public void deleteCar(String vin) {
		carRepository.deleteById(vin);
	}

	@Override
	public List<Car> getCarsByOwner(String username) {
		return userRepository.getOne(username).getCarList();
	}

}
