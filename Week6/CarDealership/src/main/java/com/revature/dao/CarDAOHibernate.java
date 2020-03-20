package com.revature.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.domain.Car;
import com.revature.exception.CarInsertionException;
import com.revature.util.SessionFactoryUtil;

@Component
public class CarDAOHibernate implements CarDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public List<Car> retrieveAllCars() {
		Session sess = sf.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Car> cq = cb.createQuery(Car.class);
		Root<Car> rootEntry = cq.from(Car.class);
		CriteriaQuery<Car> all = cq.select(rootEntry);
		
		TypedQuery<Car> allQuery = sess.createQuery(all);
		
		return allQuery.getResultList();
	}

	public void insertCar(Car car) throws CarInsertionException {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(car);
		tx.commit();
	}

	public Car retriveCarByVin(String vin) {
		Session sess = sf.openSession();
		return sess.get(Car.class, vin);
	}

}
