package com.revature.cardealership.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.cardealership.domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
	
	public List<Car> findAllByOwnerName(String ownerName);

}
