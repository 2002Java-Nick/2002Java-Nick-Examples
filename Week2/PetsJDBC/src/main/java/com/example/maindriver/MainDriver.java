package com.example.maindriver;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class MainDriver {

	public static void main(String[] args) {
		
		PetDaoImpl pdi = new PetDaoImpl();
		
		Pet petOne = new Pet("Siri", "The Doggo");
		Pet petTwo = new Pet("Zed", "The Cat");
		Pet petThree = new Pet("August", "The Cat");
		
//		pdi.insertPet(petOne);
		pdi.insertPet(petTwo);
//		pdi.insertPet(petThree);
		
//		petOne.setType("The Pupper");
//		pdi.updatePet(petOne);
		
//		System.out.println(pdi.selectAllPets());
//		pdi.deletePet(petThree);
//		System.out.println(pdi.selectAllPets());
		
	}

}
