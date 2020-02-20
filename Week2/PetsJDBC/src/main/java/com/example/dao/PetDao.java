package com.example.dao;

import java.util.List;

import com.example.model.Pet;

public interface PetDao {
	
	/*
	 * The purpose of the DAO interface
	 * is to provide us with the guideline
	 * for our CRUD operations to be performed
	 * on objects of type Model (Pet)
	 */
	
	//CREATE
	public void insertPet(Pet p);
	//READ
	public Pet selectPetByName(String name);
	public List<Pet> selectAllPets();
	//UPDATE
	public void updatePet(Pet p);
	//DELETE
	public void deletePet(Pet p);
}
