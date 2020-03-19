package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.dao.CarDAOHibernate;
import com.revature.domain.Car;
import com.revature.domain.User;
import com.revature.exception.CarInsertionException;
import com.revature.util.SessionFactoryUtil;

@RunWith(MockitoJUnitRunner.class)
public class CarDAOHibernateTest {
	
	@Mock
	SessionFactory sf;
	
	@Mock
	Session sess;
	
	@Mock
	Transaction tx;
	
	private CarDAOHibernate carDao = new CarDAOHibernate();
	
	private List<Car> carList = new ArrayList<Car>();
	
	private Car car;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		SessionFactoryUtil.setConfigFileLocationToTest();
		car = new Car("Ford", "F-120", 1999, "a number 1", new User("nick", "1234"));
		carList.clear();
		carList.add(new Car("Lambo", "F-120", 2009, "a number 2"));
		carList.add(new Car("Revature", "Reva", 2020, "a number 3"));
		carList.add(new Car("Ford", "Model T", 1901, "a number 4"));
		carList.add(new Car("Chevy", "F-120", 1998, "a number 5"));
		carList.add(new Car("Nintendo", "150cc kart", 1995, "a number 6"));
		carList.add(new Car("Toyota", "F-120", 1999, "a number 7"));
		carList.add(new Car("Ford", "Mustang", 1972, "a number 8"));
		carList.add(new Car("Honda", "Civic", 2000, "a number 9"));
		carList.add(car);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test	
	public void mockGetCarByVinUnitTest() {
		when(sess.get(Car.class, "a number 1")).thenReturn(car);
		when(sf.openSession()).thenReturn(sess);
		carDao.setSf(sf);
		assertEquals("should return expected Ford F-120", car, carDao.retriveCarByVin(car.getVin()));
		
	}
	
	@Test
	@Ignore
	public void mockGetAllCarsUnitTest() {
		when(sf.openSession()).thenReturn(sess);
		carDao.setSf(sf);
		assertEquals("should return full list of cars", carList, carDao.retrieveAllCars());
	}
	
	@Test
	public void getAllCarsIntegrationTest() {
		Session realSess = SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory().openSession();
		realSess = Mockito.spy(realSess);
		when(sf.openSession()).thenReturn(realSess);
		carDao.setSf(sf);
		List<Car> realCars = carDao.retrieveAllCars();
		System.out.println(realCars);
		assertEquals("should return all cars", carList, realCars);
	}
	
	@Test
	public void mockAddCar() throws CarInsertionException {
		when(sess.beginTransaction()).thenReturn(tx);
		when(sf.openSession()).thenReturn(sess);
		carDao.setSf(sf);
		carDao.insertCar(car);
		verify(sess).save(car);
	}
	
	@Test
	public void getCarByVinIntegrationTest() {
		Session realSess = SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory().openSession();
		realSess = Mockito.spy(realSess);
		when(sf.openSession()).thenReturn(realSess);
		carDao.setSf(sf);
		Car realCar = carDao.retriveCarByVin(car.getVin());
		System.out.println(realCar);
		assertEquals("should return expected Ford F-120", car, realCar);
		verify(realSess).get(Car.class, car.getVin());
	}

}
