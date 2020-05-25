package com.revature.Services;

/**
 * An Audi car removal service
 * <p>
 * The RemoveAudiCar interface provides a method that allows an employee
 * to remove an Audi car's information from the AWS RDS database.
 * 
 * @author josecanela
 */
public interface RemoveAudiCar {
	
	/**
	 * Removes an Audi car's information from the AWS RDS database 
	 * (no matter if it has been bought or if it is still on the lot)
	 * 
	 * @param carVin an Audi car's vehicle identification number
	 */
	public void removeAudiCar(String carVin);
}
