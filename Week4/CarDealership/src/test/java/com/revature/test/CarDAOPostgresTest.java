package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.dao.CarDAOPostgres;
import com.revature.domain.Car;
import com.revature.util.ConnectionFactory;

@RunWith(MockitoJUnitRunner.class)
public class CarDAOPostgresTest {
	
	private static final String TEST_SCHEMA = "car-dealership-test";
	
	private static final String GET_ALL_SQL = "select * from car";
	
	private CarDAOPostgres carDao = new CarDAOPostgres();
	
	private List<Car> carList = new ArrayList<Car>();
	
	@Mock
	private Connection conn;
	//@Spy -- doesn't work with interfaces
	private PreparedStatement stmt;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		carList.clear();
		carList.add(new Car("Ford", "F-120", 1999, "a number 1"));
		carList.add(new Car("Lambo", "F-120", 2009, "a number 2"));
		carList.add(new Car("Revature", "Reva", 2020, "a number 3"));
		carList.add(new Car("Ford", "Model T", 1901, "a number 4"));
		carList.add(new Car("Chevy", "F-120", 1998, "a number 5"));
		carList.add(new Car("Nintendo", "150cc kart", 1995, "a number 6"));
		carList.add(new Car("Toyota", "F-120", 1999, "a number 7"));
		carList.add(new Car("Ford", "Mustang", 1972, "a number 8"));
		carList.add(new Car("Honda", "Civic", 2000, "a number 9"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRetrieveListOfCars() throws SQLException {
		//arrange
		Connection newConn = ConnectionFactory.getConnection();
		newConn.setSchema(TEST_SCHEMA);
		PreparedStatement stmt = newConn.prepareStatement(GET_ALL_SQL);
		stmt = Mockito.spy(stmt);
		when(conn.prepareStatement(GET_ALL_SQL)).thenReturn((PreparedStatement) stmt);
		carDao.setConn(conn);
		//act
		List<Car> result = carDao.retrieveAllCars();
		//assert
		verify(stmt).executeQuery();
		assertEquals("List should match expected", carList, result);
	}

}










