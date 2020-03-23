package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.domain.Car;
import com.revature.domain.User;
import com.revature.exception.CarInsertionException;
import com.revature.service.CarService;
import com.revature.service.UserServiceImpl;

@Controller
public class CarController {
	
	private CarService carService;
	
	private UserServiceImpl userService = new UserServiceImpl();
	
	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping(path = "/car/{vin}",  method = RequestMethod.GET)
	@ResponseBody
	public Car getCar(@PathVariable String vin) {
		Car car = carService.getCar(vin);
		System.out.println(car);
		return car;
	}
	
	@GetMapping(path = "/car")
	@ResponseBody
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}
	
	@PostMapping(path = "/car", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<HttpStatus> addCar(@RequestBody Car car) {
		try {
			carService.addCar(car);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch (CarInsertionException e) {
			e.printStackTrace();
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
}
