package com.revature.Services;

/**
 * An Audi car viewing service.
 * <p>
 * This interface provides a method that allows the user to either view all the cars
 * on the lot if they are a customer, or allows the user to view all the cars
 * in the AWS RDS database if they are an employee.
 * 
 * @author josecanela
 */
public interface ViewAudiCars {
	/**
	 * Prints a list of all the AudiCars objects (in the form of Strings) that 
	 * can be found on the lot for customers.
	 * <p>
	 * Prints a list of all the AudiCar objects (in the form of Strings) that 
	 * can be found in the AWS RDS database for employees.
	 * 
	 * @param username a user's username
	 * @param password a user's password
	 */
	public void viewAudis(String username, String password);
}