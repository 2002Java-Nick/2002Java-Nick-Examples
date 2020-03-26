package com.revature.cardealership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cardealership.domain.Car;
import com.revature.cardealership.service.CarService;

@RestController
public class CarController {
	
	private CarService carService;
	
	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/car")
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}
	
	@GetMapping("/car/{vin}")
	public Car getCar(@PathVariable String vin) {
		return carService.getCarByVin(vin);
	}
	
	@PostMapping("/car")
	public void insertCar(@RequestBody Car car) {
		carService.addCar(car);
	}
	
	@DeleteMapping("/car/{vin}")
	public void deleteCar(@PathVariable String vin) {
		carService.removeCar(vin);
	}
	
	@PutMapping("/car")
	public void updateCar(@RequestBody Car car) {
		carService.updateCar(car);
	}
	
}
