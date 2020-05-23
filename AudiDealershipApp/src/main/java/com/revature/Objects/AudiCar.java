package com.revature.Objects;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author josecanela
 *
 */
@SuppressWarnings("serial")
public class AudiCar implements Serializable {
	private int carId;
	private String model;
	private String year;
	private Double price;
	private String vinNumber;
	private boolean owned;
	//private String owner;
	/**
	 * 
	 */
	public AudiCar() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Used for insertion into database
	 * @param vinNumber
	 * @param model
	 * @param year
	 * @param price
	 * @param offer
	 * @param owned 
	 * @param owner 
	 */
	public AudiCar(String model, String year, Double price,String vinNumber, boolean owned) {
		this.vinNumber = vinNumber;
		this.model = model;
		this.year = year;
		this.price = price;
		//this.offer = offer;
		this.owned = false;
		//this.owner = owner;
		
	}
	
	
	/**
	 * Used for reading Audi from database
	 * @param vinNumber
	 * @param model
	 * @param year
	 * @param price
	 * @param offer
	 * @param owned
	 * @param owner
	 */
	public void ReadAudiCar(String model, String year, Double price,String vinNumber, boolean owned) {
		this.model = model;
		this.year = year;
		this.price = price;
		this.vinNumber = vinNumber;
		//this.offer = false;
		this.owned = owned;
		//this.owner = "";
		
	}

	/**
	 * @return
	 */
	public String getVinNumber() {
		return vinNumber;
	}

	/**
	 * @param vinNumber
	 */
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	/**
	 * @return
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	
	public boolean isOwned() {
		return owned;
	}

	public void setOwned(boolean owned) {
		this.owned = owned;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "VIN: " + this.vinNumber + " Model: " + this.model + " Year: " + this.year + " Price: " + this.price;
	}

	/**
	 * @return
	 */
	public String getCarRecord() {
		return "| " + this.vinNumber + "     \t| " + this.model + "      \t| " + this.year + "     \t| " + this.price;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

                  
}
