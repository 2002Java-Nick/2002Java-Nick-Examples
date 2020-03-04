package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.domain.Car;
import com.revature.service.CarService;
import com.revature.service.CarServiceImpl;

public class CarServlet extends HttpServlet {
	
	private CarService carService = new CarServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Car> carList = carService.getAllCars();
		String carListJSON = new GsonBuilder().create().toJson(carList);
		PrintWriter pw = resp.getWriter();
		pw.write(carListJSON);
	}
	
	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	
	

}
