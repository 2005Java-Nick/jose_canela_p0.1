package com.revature.Objects;

/**
 * An Audi car.
 * 
 * @author josecanela
 */
public class AudiCar {
	/** An Audi car's ID*/
	private int carId;
	/** An Audi car's model*/
	private String model;
	/** An Audi car's year*/
	private String year;
	/** An Audi car's price*/
	private Double price;
	/** An Audi car's vehicle identification number*/
	private String vinNumber;
	/** An indication of whether or not a customer bought the Audi car*/
	private boolean owned;
	
	/**
	 * Instantiates an AudiCar object
	 */
	public AudiCar() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates an AudiCar object (that has not been bought) with a model, year, price, vehicle identification number 
	 * 
	 * 
	 * @param vinNumber an Audi car's vehicle identification number
	 * @param model an Audi car's model
	 * @param year an Audi car's year
	 * @param price an Audi car's price
	 * @param owned whether or not a customer has bought the Audi car
	 */
	public AudiCar(String model, String year, Double price,String vinNumber, boolean owned) {
		this.vinNumber = vinNumber;
		this.model = model;
		this.year = year;
		this.price = price;
		this.owned = false;
		
	}
	
	/**
	 * Instantiates an AudiCar object with with a model, year, price, vehicle identification number,
	 * and indication of whether or not a customer bought the car
	 * 
	 * @param vinNumber an Audi car's vehicle identification number
	 * @param model an Audi car's model
	 * @param year an Audi car's year
	 * @param price an Audi car's price
	 * @param owned whether or not a customer has bought the Audi car
	 */
	public void ReadAudiCar(String model, String year, Double price,String vinNumber, boolean owned) {
		this.model = model;
		this.year = year;
		this.price = price;
		this.vinNumber = vinNumber;
		this.owned = owned;
		
	}
	
	/**
	 * Gets an Audi car's ID and returns it
	 * 
	 * @return an Audi car's ID
	 */
	public int getCarId() {
		return carId;
	}

	/**
	 * Sets an Audi car's ID
	 * 
	 * @param carId an Audi car's ID
	 */
	public void setCarId(int carId) {
		this.carId = carId;
	}

	/**
	 * Gets an Audi car's vehicle identification number and returns it
	 * 
	 * @return an Audi car's vehicle identification number
	 */
	public String getVinNumber() {
		return vinNumber;
	}

	/**
	 * Sets an Audi car's vehicle identification number
	 * 
	 * @param vinNumber an Audi car's vehicle identification number
	 */
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	/**
	 * Gets an Audi car's model and returns it
	 * 
	 * @return an Audi car's model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets an Audi car's model
	 * 
	 * @param model an Audi car's model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets an Audi car's year and returns it
	 * 
	 * @return an Audi car's year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Sets an Audi car's year
	 * 
	 * @param year an Audi car's year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Gets an Audi car's price and returns it
	 * 
	 * @return an Audi car's price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets an Audi car's price
	 * 
	 * @param price an Audi car's price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	
	/**
	 * Gets whether or not a customer has bought the Audi car and returns true or false
	 * 
	 * @return whether or not a customer has bought the Audi car
	 */
	public boolean isOwned() {
		return owned;
	}

	/**
	 * Sets whether or not a customer has bought the Audi car as true or false
	 * 
	 * @param owned whether or not a customer has bought the Audi car
	 */
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
	
	@Override
	public String toString() {
		return "VIN: " + this.vinNumber + " Model: " + this.model + " Year: " + this.year + " Price: " + this.price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carId;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (owned ? 1231 : 1237);
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((vinNumber == null) ? 0 : vinNumber.hashCode());
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
		AudiCar other = (AudiCar) obj;
		if (carId != other.carId)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (owned != other.owned)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (vinNumber == null) {
			if (other.vinNumber != null)
				return false;
		} else if (!vinNumber.equals(other.vinNumber))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

                  
}
