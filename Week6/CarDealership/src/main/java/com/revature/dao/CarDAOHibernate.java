package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.domain.Car;
import com.revature.exception.CarInsertionException;
import com.revature.util.SessionFactoryUtil;

public class CarDAOHibernate implements CarDAO {
	
	private static SessionFactory sf = SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory();
	
	public static void setSessionFactory(SessionFactory sf) {
		CarDAOHibernate.sf = sf;
	}

	public List<Car> retrieveAllCars() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertCar(Car car) throws CarInsertionException {
		// TODO Auto-generated method stub
		
	}

	public Car retriveCarByVin(String vin) {
		Session sess = sf.openSession();
		return sess.get(Car.class, vin);
	}

}
