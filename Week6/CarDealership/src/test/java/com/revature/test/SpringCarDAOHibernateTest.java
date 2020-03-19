package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.config.AppConfig;
import com.revature.dao.CarDAOHibernate;
import com.revature.domain.Car;
import com.revature.domain.User;
import com.revature.util.SessionFactoryUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class SpringCarDAOHibernateTest {
	
	@InjectMocks
	private CarDAOHibernate carDao = new CarDAOHibernate();
	
	@Mock
	private SessionFactory sf;
	
	@Mock
	private Session sess;
	
	private static Car car;
	
	private static List<Car> carList = new ArrayList<Car>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test	
	public void mockGetCarByVinUnitTest() {
		when(sess.get(Car.class, "a number 1")).thenReturn(car);
		when(sf.openSession()).thenReturn(sess);
		assertEquals("should return expected Ford F-120", car, carDao.retriveCarByVin(car.getVin()));
		
	}

}
