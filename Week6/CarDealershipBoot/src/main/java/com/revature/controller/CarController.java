package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.Car;
import com.revature.service.CarService;

@RestController
public class CarController {

	private CarService carService;

	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@GetMapping(path = "/car/{vin}")
	public Car getCar(@PathVariable String vin) {
		Car car = carService.getCarByVin(vin);
		System.out.println(car);
		return car;
	}

	@GetMapping(path = "/car")
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}
	
	@GetMapping(path = "/car/user/{username}")
	public List<Car> getCarsByOwner(@PathVariable String username) {
		return carService.getCarsByOwner(username);
	}
	
	@PutMapping(path = "/car")
	public void updateCar(@RequestBody Car car) {
		carService.updateCar(car);
	}
	
	@DeleteMapping(path = "/car/{vin}")
	public void deleteCar(@PathVariable String vin) {
		carService.deleteCar(vin);
	}

	@PostMapping(path = "/car", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> addCar(@RequestBody Car car) {
		carService.insertCar(car);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	

}
