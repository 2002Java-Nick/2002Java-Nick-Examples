package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.domain.Car;
import com.revature.service.CarService;

@Controller
public class CarController {
	
	private CarService carService;
	
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
	
}
