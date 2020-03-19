package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gson.GsonBuilder;
import com.revature.domain.Car;
import com.revature.service.CarService;
import com.revature.servlet.CarServlet;

@RunWith(MockitoJUnitRunner.class)
public class CarServletTest {
	
	private CarServlet carServlet = new CarServlet();
	
	private List<Car> carList = new ArrayList<Car>();
	
	@Mock
	private CarService carService;

	@Mock
	HttpServletRequest req;
	
	@Mock
	HttpServletResponse resp;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		carList.add(new Car("Ford", "F-120", 1920500, "1"));
		carList.add(new Car("Chevy", "Sonic", 2013, "2"));
		when(carService.getAllCars()).thenReturn(carList);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws ServletException, IOException {
		carServlet.setCarService(carService);
		String json = new GsonBuilder().create().toJson(carList);
		Writer sWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(sWriter);
		when(resp.getWriter()).thenReturn(writer);
		when(req.getMethod()).thenReturn("GET");
		carServlet.service(req, resp);
		assertEquals("Should print value " + json, json, sWriter.toString());
		
	}

}
