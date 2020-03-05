package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Car;
import com.revature.util.ConnectionFactory;

public class CarDAOPostgres implements CarDAO {
	
	private Connection conn = ConnectionFactory.getConnection();
	
	private static final String CAR_TABLE = "car";
	private static final String SELECT_ALL_CARS = "select * from " + CAR_TABLE; 

	public List<Car> retrieveAllCars() {
		List<Car> carList = new ArrayList<Car>();
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_CARS);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				carList.add(
						new Car(rs.getString("make"), 
						rs.getString("model"), 
						rs.getInt("year"), 
						rs.getString("vin")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carList;
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
