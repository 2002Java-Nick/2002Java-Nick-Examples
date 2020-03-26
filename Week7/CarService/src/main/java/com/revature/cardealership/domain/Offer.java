package com.revature.cardealership.domain;

public class Offer {

	private int offerId;
	
	private String username;
	
	private String vin;
	
	private double offerAmount;
	
	private boolean active;

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public double getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(offerAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + offerId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
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
		Offer other = (Offer) obj;
		if (active != other.active)
			return false;
		if (Double.doubleToLongBits(offerAmount) != Double.doubleToLongBits(other.offerAmount))
			return false;
		if (offerId != other.offerId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", username=" + username + ", vin=" + vin + ", offerAmount=" + offerAmount
				+ ", active=" + active + "]";
	}

	public Offer(int offerId, String username, String vin, double offerAmount, boolean active) {
		super();
		this.offerId = offerId;
		this.username = username;
		this.vin = vin;
		this.offerAmount = offerAmount;
		this.active = active;
	}

	public Offer() {
		super();
	}
	
}
