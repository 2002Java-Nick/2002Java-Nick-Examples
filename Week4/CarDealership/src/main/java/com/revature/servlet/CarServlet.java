package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.security.sasl.SaslClient;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.domain.Car;
import com.revature.exception.CarInsertionException;
import com.revature.service.CarService;
import com.revature.service.CarServiceImpl;

public class CarServlet extends HttpServlet {

	private CarService carService = new CarServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if (sess != null && sess.getAttribute("user") != null) { // user has logged in
			List<Car> carList = carService.getAllCars();
			String carListJSON = new GsonBuilder().create().toJson(carList);
			PrintWriter pw = resp.getWriter();
			pw.write(carListJSON);
		} else {
			resp.getWriter().write("User not logged in");
			resp.setStatus(resp.SC_UNAUTHORIZED);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);

		if (sess != null && sess.getAttribute("user") != null) { // user has logged in
			System.out.println("Logged in");
			System.out.println(sess.getAttribute("user"));
			String carJson = req.getReader().readLine();
			System.out.println(carJson);
			Car myCar = new GsonBuilder().create().fromJson(carJson, Car.class);
			try {
				carService.addCar(myCar);
				resp.getWriter().write("Success");
			} catch (CarInsertionException e) {
				resp.setStatus(resp.SC_INTERNAL_SERVER_ERROR);
				resp.getWriter().write("Car could not be created");
			}
		} else {
			resp.getWriter().write("User not logged in");
			resp.setStatus(resp.SC_UNAUTHORIZED);
		}

	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

}
