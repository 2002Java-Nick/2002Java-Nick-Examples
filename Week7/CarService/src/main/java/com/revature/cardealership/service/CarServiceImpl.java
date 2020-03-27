package com.revature.cardealership.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cardealership.domain.Car;
import com.revature.cardealership.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository carRepository;

	@Autowired
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public Car getCarByVin(String vin) {
		Optional<Car> opt = carRepository.findById(vin);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	@Override
	public void addCar(Car car) {
		Optional<Car> existingCar = carRepository.findById(car.getVin());
		if (!existingCar.isPresent()) {
			carRepository.save(car);
		} else {
			//TODO: handle if car already exists
		}
	}

	@Override
	public void removeCar(String vin) {
		carRepository.deleteById(vin);
	}

	@Override
	public void updateCar(Car car) {
		carRepository.save(car);
	}

	@Override
	public List<Car> getCarsByOwner(String owner) {
		return carRepository.findAllByOwnerName(owner);
	}

}
