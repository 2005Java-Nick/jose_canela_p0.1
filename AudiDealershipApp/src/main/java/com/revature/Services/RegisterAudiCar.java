package com.revature.Services;

/**
 * @author josecanela
 *
 */
public interface RegisterAudiCar {
	
		/**
		 * Employees can add an Audi's to the lot
		 * @param vinNumber
		 * @param model
		 * @param year
		 * @param price
		 */
		public void addAudiCar(String vinNumber, String model, String year, Double price);
}
