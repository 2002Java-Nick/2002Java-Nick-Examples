package com.revature.cardealership.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Car {
	
	@Id
	@Column(name = "vin")
	private String vin;

	@Column
	private String make;
	
	@Column
	private String model;
	
	@Column
	private String year;
	
	@Column
	private double price;
	
	@Column
	private String ownerName;
	
	@Transient
	private List<Offer> offerList;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public List<Offer> getOfferList() {
		return offerList;
	}

	public void setOfferList(List<Offer> offerList) {
		this.offerList = offerList;
	}

	public Car(String vin, String make, String model, String year, double price, String ownerName,
			List<Offer> offerList) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.ownerName = ownerName;
		this.offerList = offerList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((offerList == null) ? 0 : offerList.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (offerList == null) {
			if (other.offerList != null)
				return false;
		} else if (!offerList.equals(other.offerList))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	public Car() {
		super();
	}

	@Override
	public String toString() {
		return "Car [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", price=" + price
				+ ", ownerName=" + ownerName + ", offerList=" + offerList + "]";
	}


	
}
