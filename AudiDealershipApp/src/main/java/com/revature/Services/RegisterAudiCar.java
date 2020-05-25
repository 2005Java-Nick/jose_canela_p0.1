package com.revature.Services;

/**
 * An Audi car registration service
 * <p> 
 * The RegisterAudiCar interface provides a method that allows an employee
 * to register a car and add it to the lot.
 * 
 * @author josecanela
 */
public interface RegisterAudiCar {
	
		/**
		 * Creates a AudiCar object and inserts it's information into the RDS database
		 * utilizing JDBC - hence, adding an Audi car to the lot.
		 * 
		 * @param vinNumber an Audi car's vechicle identification number
		 * @param model an Audi car's model
		 * @param year an Audi car's year
		 * @param price an Audi car's price
		 */
		public void addAudiCar(String vinNumber, String model, String year, Double price);
}
