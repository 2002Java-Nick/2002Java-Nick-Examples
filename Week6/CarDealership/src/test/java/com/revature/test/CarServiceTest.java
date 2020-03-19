package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.dao.CarDAO;
import com.revature.domain.Car;
import com.revature.service.CarServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
	
	@Mock
	private CarDAO carDao;
	
	private List<Car> carList = new ArrayList<Car>();
	
	private CarServiceImpl carService = new CarServiceImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		carList.clear();
		carList.add(new Car("Ford", "F-120", 1920500, "1"));
		carList.add(new Car("Chevy", "Sonic", 2013, "2"));
		when(carDao.retrieveAllCars()).thenReturn(carList);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		carService.setCarDao(carDao);
		assertEquals("should return right list", carList, carService.getAllCars());
	}

}













